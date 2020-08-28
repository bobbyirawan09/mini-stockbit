package bobby.irawan.ministockbit.data.model

import com.google.gson.annotations.SerializedName

data class DisplayDetailResponse(
    @SerializedName("CHANGE24HOUR")
    val change24Hour: String,
    @SerializedName("CHANGEDAY")
    val changeDay: String,
    @SerializedName("CHANGEHOUR")
    val changeHour: String,
    @SerializedName("CHANGEPCT24HOUR")
    val changePCT24Hour: String,
    @SerializedName("CHANGEPCTDAY")
    val changePCTDay: String,
    @SerializedName("CHANGEPCTHOUR")
    val changePCTHour: String,
    @SerializedName("CONVERSIONSYMBOL")
    val conversionSymbol: String,
    @SerializedName("CONVERSIONTYPE")
    val conversionType: String,
    @SerializedName("FROMSYMBOL")
    val fromSymbol: String,
    @SerializedName("HIGH24HOUR")
    val high24Hour: String,
    @SerializedName("HIGHDAY")
    val highDay: String,
    @SerializedName("HIGHHOUR")
    val highHour: String,
    @SerializedName("IMAGEURL")
    val imageUrl: String,
    @SerializedName("LASTMARKET")
    val lastMarket: String,
    @SerializedName("LASTTRADEID")
    val lastTradeId: String,
    @SerializedName("LASTUPDATE")
    val lastUpdate: String,
    @SerializedName("LASTVOLUME")
    val lastVolume: String,
    @SerializedName("LASTVOLUMETO")
    val lastVolumeTo: String,
    @SerializedName("LOW24HOUR")
    val low24Hour: String,
    @SerializedName("LOWDAY")
    val lowDay: String,
    @SerializedName("LOWHOUR")
    val lowHour: String,
    @SerializedName("MARKET")
    val market: String,
    @SerializedName("MKTCAP")
    val marketCap: String,
    @SerializedName("OPEN24HOUR")
    val open24Hour: String,
    @SerializedName("OPENDAY")
    val openDay: String,
    @SerializedName("OPENHOUR")
    val openHour: String,
    @SerializedName("PRICE")
    val price: String,
    @SerializedName("SUPPLY")
    val supply: String,
    @SerializedName("TOPTIERVOLUME24HOUR")
    val topTierVolume24Hour: String,
    @SerializedName("TOPTIERVOLUME24HOURTO")
    val topTierVolume24HourTo: String,
    @SerializedName("TOSYMBOL")
    val toSymbol: String,
    @SerializedName("TOTALTOPTIERVOLUME24H")
    val totaltopTierVolume24H: String,
    @SerializedName("TOTALtoPTIERVOLUME24Hto")
    val totaltopTierVolume24HTo: String,
    @SerializedName("TOTALVOLUME24H")
    val totalVolume24H: String,
    @SerializedName("TOTALVOLUME24HTO")
    val totalVolume24HTo: String,
    @SerializedName("VOLUME24HOUR")
    val volume24Hour: String,
    @SerializedName("VOLUME24HOURTO")
    val volume24HourTo: String,
    @SerializedName("VOLUMEDAY")
    val volumeDay: String,
    @SerializedName("VOLUMEDAYTO")
    val volumeDayTo: String,
    @SerializedName("VOLUMEHOUR")
    val volumeHour: String,
    @SerializedName("VOLUMEHOURTO")
    val volumeHourTo: String
)