package bobby.irawan.ministockbit.domain.usecase

import bobby.irawan.ministockbit.domain.repository.CryptoRepository

/**
 * Created by bobbyirawan09 on 27/08/20.
 */
class GetWebSocketUseCase(private val repository: CryptoRepository) {
    suspend fun execute() = repository.getWebSocketData()
}