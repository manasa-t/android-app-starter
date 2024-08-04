package com.manasa.core.baseclasses

import android.accounts.NetworkErrorException
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.manasa.core.entities.ResultData
import retrofit2.Response
import timber.log.Timber
import java.net.ConnectException
import java.net.UnknownHostException

 abstract class BaseRemoteDatasource {

    protected suspend fun <T> getData(call: suspend () -> Response<T>): ResultData<T> {
        try {
            Timber.d(" called from data source")
            val req = call()

            if (req.isSuccessful) {
                val body = req.body()
                Timber.d("response received " + body.toString())
                if (body != null) return ResultData.success(body)
            }
            var errorMessage = req.message()
            try {
                val gson = Gson()
                val type = object : TypeToken<ResultData.ApiErrorResponse>() {}.type
                var errorResponse: ResultData.ApiErrorResponse? =
                    gson.fromJson(req.errorBody()!!.charStream(), type)
                if (errorResponse != null) {
                    errorMessage = errorResponse.message
                }
            } catch (gsonException: Exception) {
                Timber.e("GetData - Exception parsing Error Response, Fallback to Network Response")
            } finally {
                return formatError(" ${req.code()} $errorMessage")
            }
        } catch (ex: Throwable) {
            return getError(ex)
        }
    }

    private fun <T> formatError(errorMessage: String): ResultData<T> {
        Timber.d("Error getting data $errorMessage")
        return ResultData.failure("Network call has failed for the following reason: $errorMessage")
    }

    private fun <T> getError(ex: Throwable): ResultData<T> {
        Timber.d("Error getting data ${ex.message}")
        return when (ex) {
            is NetworkErrorException,
            is UnknownHostException,
            is ConnectException -> {
                ResultData.failure("Something went wrong, Please try again later.")
            }
            else -> {
                ResultData.failure("Network call has failed for the following reason: ${ex.message}")
            }
        }
    }
}