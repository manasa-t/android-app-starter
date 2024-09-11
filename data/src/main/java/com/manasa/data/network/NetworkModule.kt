package com.manasa.data.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.manasa.data.BuildConfig

import com.manasa.data.network.NetworkConstants.CONNECT_TIMEOUT
import com.manasa.data.network.NetworkConstants.READ_TIMEOUT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideChuckerInterceptor(@ApplicationContext context: Context): ChuckerInterceptor{
        return ChuckerInterceptor.Builder(context).build()
    }
    
    @Singleton
    @Provides
    fun provideOkHttpClient(chuckerInterceptor: ChuckerInterceptor) : OkHttpClient {
        val okhttpClientBuilder = OkHttpClient.Builder()
        okhttpClientBuilder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        okhttpClientBuilder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        if(BuildConfig.DEBUG) {
           // okhttpClientBuilder.addInterceptor(HttpLoggingInterceptor())
            okhttpClientBuilder.addInterceptor(chuckerInterceptor)
        }
        return okhttpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .baseUrl("")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//    @Singleton
//    @Provides
//    fun provideFeatureApiService(retrofit: Retrofit): FeatureApiService{
//        return retrofit.create(FeatureApiService::class.java)
//    }


}