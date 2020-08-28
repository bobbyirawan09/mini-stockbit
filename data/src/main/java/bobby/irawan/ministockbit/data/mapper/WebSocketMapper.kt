package bobby.irawan.ministockbit.data.mapper

import bobby.irawan.ministockbit.data.model.CryptoResponse
import bobby.irawan.ministockbit.data.model.WebSocketResponse
import bobby.irawan.ministockbit.domain.model.CryptoModel
import bobby.irawan.ministockbit.domain.model.WebSocketModel

/**
 * Created by bobbyirawan09 on 28/08/20.
 */
class WebSocketMapper : Mapper<WebSocketResponse, WebSocketModel> {
    override fun mapFromResponse(response: WebSocketResponse): WebSocketModel {
        return WebSocketModel(
            response.type,
            response.symbol,
            response.topTierFullVolume
        )
    }
}