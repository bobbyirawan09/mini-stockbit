package bobby.irawan.ministockbit.data.common

import bobby.irawan.ministockbit.data.interceptor.ApiKeyInterceptor
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
            OkHttpWebSocket(httpClient(), OkHttpWebSocket.SimpleRequestFactory(
                {
                    Request.Builder()
                        .url(baseUrl + "?api_key=0377b645534d613665813aec1f9d5afa4980955e898e15d095f343274673fe1d")
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

    private fun httpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    private fun apiKeyInterceptor(apiKey: String): Interceptor {
        return ApiKeyInterceptor(apiKey)
    }

}