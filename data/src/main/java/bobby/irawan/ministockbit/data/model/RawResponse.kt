package bobby.irawan.ministockbit.data.model

import com.google.gson.annotations.SerializedName

data class RawResponse(
    @SerializedName("IDR")
    val rawDetail: RawDetailResponse
)