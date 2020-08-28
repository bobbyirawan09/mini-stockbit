package bobby.irawan.ministockbit.data.mapper

import bobby.irawan.ministockbit.data.model.CryptoResponse
import bobby.irawan.ministockbit.domain.model.CryptoModel

class CryptoMapper : Mapper<List<CryptoResponse>, List<CryptoModel>> {
    override fun mapFromResponse(responses: List<CryptoResponse>): List<CryptoModel> {
        return responses.map {response ->
            CryptoModel(
                response.coinInfo.name,
                response.coinInfo.fullName,
                response.raw.rawDetail.price,
                response.raw.rawDetail.changeHour,
                response.raw.rawDetail.changePCTHour
            )
        }
    }
}
