package com.manasa.core.entities

import androidx.annotation.Keep
import java.io.Serializable

sealed class ResultData<out T>{

    data class Success<out T>(val value: T) : ResultData<T>()

    data class Failure<out T>(val message: String, val code: Int?) : ResultData<T>()


    companion object {

        fun <T> success(value: T): ResultData<T> = Success(value)

        fun <T> failure(error_msg: String, error_code: Int? = 0): ResultData<T> =
            Failure(error_msg, error_code)

    }

    @Keep
    class ApiErrorResponse(
        val errors: Any,
        val message: String,
    ) : Serializable
}