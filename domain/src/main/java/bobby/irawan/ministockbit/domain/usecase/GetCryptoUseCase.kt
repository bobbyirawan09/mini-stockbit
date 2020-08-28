package bobby.irawan.ministockbit.domain.usecase

import bobby.irawan.ministockbit.domain.common.ParamUseCase
import bobby.irawan.ministockbit.domain.model.CryptoModel
import bobby.irawan.ministockbit.domain.model.CryptoRequest
import bobby.irawan.ministockbit.domain.repository.CryptoRepository

/**
 * Created by bobbyirawan09 on 25/08/20.
 */
class GetCryptoUseCase(private val repository: CryptoRepository) :
    ParamUseCase<CryptoRequest, List<CryptoModel>>() {
    override suspend fun execute(param: CryptoRequest) = repository.getCryptoData(param)
}