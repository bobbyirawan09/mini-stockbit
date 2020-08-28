package bobby.irawan.ministockbit.data.service

import bobby.irawan.ministockbit.data.service.interceptor.ApiKeyInterceptor
import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.messageadapter.gson.GsonMessageAdapter
import com.tinder.scarlet.retry.ExponentialWithJitterBackoffStrategy
import com.tinder.scarlet.websocket.ShutdownReason
import com.tinder.scarlet.websocket.okhttp.OkHttpWebSocket
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

/**
 * Created by bobbyirawan09 on 27/08/20.
 */
object ScarletFactory {

    private val backoffStrategy = ExponentialWithJitterBackoffStrategy(5000, 5000)

    fun create(baseUrl: String, apiKey: String): Scarlet {
        return Scarlet(
            OkHttpWebSocket(
                httpClient(
                    apiKey
                ), OkHttpWebSocket.SimpleRequestFactory(
                    {
                        Request.Builder()
                            .url(baseUrl)
                            .build()
                    },
                    { ShutdownReason.GRACEFUL }
                )),
            Scarlet.Configuration(
                backoffStrategy = backoffStrategy,
                messageAdapterFactories = listOf(GsonMessageAdapter.Factory()),
                streamAdapterFactories = listOf(FlowStreamAdapter.Factory)
            )
        )
    }

    private fun httpClient(apiKey: String): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                apiKeyInterceptor(
                    apiKey
                )
            )
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    private fun apiKeyInterceptor(apiKey: String): Interceptor {
        return ApiKeyInterceptor(apiKey)
    }

}