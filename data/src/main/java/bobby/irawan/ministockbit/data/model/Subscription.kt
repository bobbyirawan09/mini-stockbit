package bobby.irawan.ministockbit.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by bobbyirawan09 on 27/08/20.
 */
data class Subscription(
    @SerializedName("action")
    var action: String,
    @SerializedName("subs")
    var subs: List<String>
)