package bobby.irawan.ministockbit.domain.model

/**
 * Created by bobbyirawan09 on 26/08/20.
 */
data class CryptoRequest(
    var pageNum: Int,
    var limit: Int = 10,
    var tsym: String = "IDR"
)