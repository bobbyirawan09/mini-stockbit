package bobby.irawan.ministockbit.data.model

import com.google.gson.annotations.SerializedName

data class WeissResponse(
    @SerializedName("MarketPerformanceRating")
    val marketPerformanceRating: String,
    @SerializedName("Rating")
    val rating: String,
    @SerializedName("TechnologyAdoptionRating")
    val technologyAdoptionRating: String
)