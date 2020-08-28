package bobby.irawan.ministockbit.domain.model

/**
 * Created by bobbyirawan09 on 25/08/20.
 */
data class CryptoModel(
    var name: String,
    var fullName: String,
    var currentPrice: Double,
    var changePrice: Double,
    var changePricePercent: Double
)