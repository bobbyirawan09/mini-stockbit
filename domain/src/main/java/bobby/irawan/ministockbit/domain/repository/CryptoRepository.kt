package bobby.irawan.ministockbit.domain.repository

import bobby.irawan.ministockbit.domain.common.SimpleResult
import bobby.irawan.ministockbit.domain.model.CryptoModel
import bobby.irawan.ministockbit.domain.model.CryptoRequest
import bobby.irawan.ministockbit.domain.model.WebSocketModel
import kotlinx.coroutines.flow.Flow

/**
 * Created by bobbyirawan09 on 25/08/20.
 */
interface CryptoRepository {
    suspend fun getCryptoData(param: CryptoRequest): SimpleResult<List<CryptoModel>>
    suspend fun getWebSocketData(): Flow<WebSocketModel>
}