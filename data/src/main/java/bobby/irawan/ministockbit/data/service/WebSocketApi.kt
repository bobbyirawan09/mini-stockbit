package bobby.irawan.ministockbit.data.service

import bobby.irawan.ministockbit.data.model.Subscription
import bobby.irawan.ministockbit.data.model.WebSocketResponse
import com.tinder.scarlet.websocket.WebSocketEvent
import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import kotlinx.coroutines.flow.Flow

/**
 * Created by bobbyirawan09 on 27/08/20.
 */
interface WebSocketApi {

    @Send
    fun subscribe(request: Subscription): Boolean

    @Receive
    fun observeResponse(): Flow<WebSocketResponse>

    @Receive
    fun observeConnection(): Flow<WebSocketEvent>
}