package bobby.irawan.helper

import bobby.irawan.ministockbit.data.model.*
import bobby.irawan.ministockbit.domain.common.Result
import bobby.irawan.ministockbit.domain.common.SimpleError
import bobby.irawan.ministockbit.domain.model.CryptoModel
import bobby.irawan.ministockbit.domain.model.CryptoRequest
import bobby.irawan.ministockbit.domain.model.WebSocketModel

/**
 * Created by bobbyirawan09 on 29/08/20.
 */
object MockData {

    val webSocketModel = WebSocketModel(21, "BTC", 1000.0)
    val webSocketResponse = WebSocketResponse(21, "BTC", 1000.0)
    val errorWebSocketResponse = WebSocketResponse(0, "0", 0.0)
    val errorWebSocketModel = WebSocketModel(0, "", 0.0)
    val subscribeModel = Subscription("SubAdd", listOf("21~BTC"))
    val page = 1
    val limit = 10
    val tsym = "IDR"
    val requestParam = CryptoRequest(page, limit, tsym)

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
    val successResultCrypto = Result.Success.Data(cryptoList)
    val failureResultCrypto = Result.Failure(SimpleError())

    val cryptoResponse = CryptoResponse(
        CoinInfoResponse(
            "",
            0,
            0.0,
            0,
            "",
            "",
            "",
            "",
            "",
            "",
            0.0,
            "",
            RatingResponse(WeissResponse("", "", "")),
            0,
            ""
        ),
        DisplayResponse(
            DisplayDetailResponse(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
            )
        ),
        RawResponse(
            RawDetailResponse(
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                "",
                "",
                "",
                "",
                0.0,
                0.0,
                0.0,
                "",
                "",
                "",
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                "",
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                "",
                0.0,
                0.0,
                0.0,
                0.0,
                "",
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0
            )
        )
    )

    val baseResponse = BaseResponse<List<CryptoResponse>>()
}