package bobby.irawan.ministockbit.data.service

import bobby.irawan.ministockbit.data.service.interceptor.ApiKeyInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitFactory {

    fun create(baseUrl: String, apiKey: String): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                createOkHttp(
                    apiKey
                )
            )
            .build()
    }

    private fun createOkHttp(apiKey: String): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor())
            .addInterceptor(
                apiKeyInterceptor(
                    apiKey
                )
            )
            .connectTimeout(30, TimeUnit.SECONDS)
            .callTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    private fun loggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    private fun apiKeyInterceptor(apiKey: String): Interceptor {
        return ApiKeyInterceptor(apiKey)
    }
}
