package bobby.irawan.ministockbit.data.model

import com.google.gson.annotations.SerializedName

data class CryptoResponse(
    @SerializedName("CoinInfo")
    val coinInfo: CoinInfoResponse,
    @SerializedName("DISPLAY")
    val display: DisplayResponse,
    @SerializedName("RAW")
    val raw: RawResponse
)