package bobby.irawan.ministockbit.domain.usecase

import bobby.irawan.ministockbit.domain.base.ParamUseCase
import bobby.irawan.ministockbit.domain.common.SimpleResult
import bobby.irawan.ministockbit.domain.model.CryptoModel
import bobby.irawan.ministockbit.domain.model.CryptoRequest
import bobby.irawan.ministockbit.domain.repository.CryptoRepository

/**
 * Created by bobbyirawan09 on 25/08/20.
 */
class GetCryptoUseCase(private val repository: CryptoRepository): ParamUseCase<CryptoRequest, List<CryptoModel>>() {
    override suspend fun execute(param: CryptoRequest): SimpleResult<List<CryptoModel>> {
        return repository.getCryptoData(param)
    }
}