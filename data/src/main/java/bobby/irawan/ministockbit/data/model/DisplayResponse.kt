package bobby.irawan.ministockbit.data.model

import com.google.gson.annotations.SerializedName

data class DisplayResponse(
    @SerializedName("IDR")
    val displayDetail: DisplayDetailResponse
)