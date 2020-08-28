package bobby.irawan.ministockbit.data.model

import com.google.gson.annotations.SerializedName

data class CoinInfoResponse(
    @SerializedName("Algorithm")
    val algorithm: String,
    @SerializedName("BlockNumber")
    val blockNumber: Int,
    @SerializedName("BlockReward")
    val blockReward: Double,
    @SerializedName("BlockTime")
    val blockTime: Int,
    @SerializedName("DocumentType")
    val documentType: String,
    @SerializedName("FullName")
    val fullName: String,
    @SerializedName("Id")
    val id: String,
    @SerializedName("ImageUrl")
    val imageUrl: String,
    @SerializedName("Internal")
    val internal: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("NetHashesPerSecond")
    val netHashesPerSecond: Double,
    @SerializedName("ProofType")
    val proofType: String,
    @SerializedName("Rating")
    val rating: RatingResponse,
    @SerializedName("Type")
    val type: Int,
    @SerializedName("Url")
    val url: String
)