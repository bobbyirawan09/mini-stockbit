package bobby.irawan.ministockbit.data

import bobby.irawan.ministockbit.data.common.Constants.WEB_SOCKET_SUBSCRIBE_MODEL
import bobby.irawan.ministockbit.data.common.mapToResult
import bobby.irawan.ministockbit.data.mapper.CryptoMapper
import bobby.irawan.ministockbit.data.mapper.WebSocketMapper
import bobby.irawan.ministockbit.data.model.Subscription
import bobby.irawan.ministockbit.data.service.CryptoAPI
import bobby.irawan.ministockbit.data.service.WebSocketApi
import bobby.irawan.ministockbit.domain.common.Result
import bobby.irawan.ministockbit.domain.common.SimpleError
import bobby.irawan.ministockbit.domain.common.SimpleResult
import bobby.irawan.ministockbit.domain.model.CryptoModel
import bobby.irawan.ministockbit.domain.model.CryptoRequest
import bobby.irawan.ministockbit.domain.repository.CryptoRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class CryptoRepositoryImpl(
    private val api: CryptoAPI,
    private val cryptoMapper: CryptoMapper,
    private val webSocketMapper: WebSocketMapper,
    private val webSocket: WebSocketApi
) :
    CryptoRepository {

    override suspend fun getCryptoData(param: CryptoRequest): SimpleResult<List<CryptoModel>> {
        return try {
            api.getCryptoData(param.limit, param.pageNum, param.tsym).mapToResult(cryptoMapper)
        } catch (e: Exception) {
            Result.Failure(SimpleError(e.localizedMessage))
        }
    }

    @ExperimentalCoroutinesApi
    override suspend fun getWebSocketData() = flow {
        webSocket.subscribe(WEB_SOCKET_SUBSCRIBE_MODEL)
        webSocket.observeResponse().collect { response ->
            emit(webSocketMapper.mapFromResponse(response))
        }
    }
}