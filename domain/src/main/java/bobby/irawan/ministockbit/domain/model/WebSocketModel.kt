package bobby.irawan.ministockbit.domain.model

/**
 * Created by bobbyirawan09 on 27/08/20.
 */
data class WebSocketModel (
    var type: Int? = 0,
    var symbol: String? = "",
    var topTierFullVolume: Double? = 0.0
)