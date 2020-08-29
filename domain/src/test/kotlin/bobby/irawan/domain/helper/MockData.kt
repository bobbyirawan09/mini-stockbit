package bobby.irawan.domain.helper

import bobby.irawan.ministockbit.domain.common.Result
import bobby.irawan.ministockbit.domain.model.CryptoModel
import bobby.irawan.ministockbit.domain.model.CryptoRequest
import bobby.irawan.ministockbit.domain.model.WebSocketModel

/**
 * Created by bobbyirawan09 on 29/08/20.
 */
object MockData {

    val webSocketModel = WebSocketModel(21, "BTC", 1000.0)
    val errorWebSocketModel = WebSocketModel(0, "", 0.0)

    val request = CryptoRequest(1)
    val cryptoModel = CryptoModel(
        "",
        "",
        0.0,
        0.0,
        0.0
    )
    val cryptoList = listOf(cryptoModel, cryptoModel)
    val emptyResult = Result.Success.NoData
    val nonEmptyResult = Result.Success.Data(cryptoList)
}