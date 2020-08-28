package bobby.irawan.ministockbit.data.mapper

import bobby.irawan.ministockbit.data.model.CryptoResponse
import bobby.irawan.ministockbit.domain.model.CryptoModel

class CryptoMapper : Mapper<List<CryptoResponse>, List<CryptoModel>> {
    override fun mapFromResponse(response: List<CryptoResponse>): List<CryptoModel> {
        return response.map {
            CryptoModel(
                it.coinInfo.name,
                it.coinInfo.fullName,
                it.raw.rawDetail.price,
                it.raw.rawDetail.changeHour,
                it.raw.rawDetail.changePCTHour
            )
        }
    }
}
