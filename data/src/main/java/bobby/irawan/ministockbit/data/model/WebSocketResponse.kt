package bobby.irawan.ministockbit.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by bobbyirawan09 on 27/08/20.
 */
data class WebSocketResponse(
    @SerializedName("TYPE")
    val type: Int,
    @SerializedName("SYMBOL")
    val symbol: String,
    @SerializedName("TOPTIERFULLVOLUME")
    val topTierFullVolume: Double
)