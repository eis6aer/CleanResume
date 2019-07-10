package com.developer76.data.service

import android.util.Log
import com.developer76.data.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetroFitFactory {

    companion object {
        private const val TAG = "ApiService"
        private const val CONN_TIMEOUT_MILLIS = 12000L
        private const val READ_TIMEOUT_MILLIS = 12000L
        private val BASE_URL: String = BuildConfig.BASE_URL

        private fun getInstance() : Retrofit.Builder
        {
            Log.d(TAG,"getInstance() called")
            val clientBuilder = OkHttpClient().newBuilder()

            val interceptor = Interceptor {
                    chain ->
                val request = chain.request()
                var response = chain.proceed(request)
                var tryOuts = 1

                while (!response.isSuccessful && tryOuts < 3) {
                    Log.d(TAG, "intercept: timeout/connection failure, performing automatic retry ${(tryOuts + 1)}")
                    tryOuts++
                    response = chain.proceed(request)
                }
                response
            }

            var loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            clientBuilder.connectTimeout(CONN_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            clientBuilder.readTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)

            clientBuilder.addInterceptor(loggingInterceptor)
            clientBuilder.addInterceptor(interceptor)

            Log.d(TAG, "getInstance() completed")

            val gson = GsonBuilder()
                .setLenient().create()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(clientBuilder.build())
        }

        fun <T> getService(type: Class<T>) : T
        {
            Log.d(TAG, "getServiceInstance() called with: type = [$type]")
            var retrofit = getInstance()
            return retrofit.build().create(type)
        }
    }

}