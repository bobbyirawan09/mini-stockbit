package bobby.irawan.ministockbit.data.model

import com.google.gson.annotations.SerializedName

data class RawDetailResponse(
    @SerializedName("CHANGE24HOUR")
    val change24Hour: Double,
    @SerializedName("CHANGEDAY")
    val changeDay: Double,
    @SerializedName("CHANGEHOUR")
    val changeHour: Double,
    @SerializedName("CHANGEPCT24HOUR")
    val changePCT24Hour: Double,
    @SerializedName("CHANGEPCTDAY")
    val changePCTDay: Double,
    @SerializedName("CHANGEPCTHOUR")
    val changePCTHour: Double,
    @SerializedName("CONVERSIONSYMBOL")
    val conversionSymbol: String,
    @SerializedName("CONVERSIONTYPE")
    val conversionType: String,
    @SerializedName("FLAGS")
    val flags: String,
    @SerializedName("FROMSYMBOL")
    val fromSymbol: String,
    @SerializedName("HIGH24HOUR")
    val high24Hour: Double,
    @SerializedName("HIGHDAY")
    val highDay: Double,
    @SerializedName("HIGHHOUR")
    val highHour: Double,
    @SerializedName("IMAGEURL")
    val imageUrl: String,
    @SerializedName("LASTMARKET")
    val lastMarket: String,
    @SerializedName("LASTTRADEID")
    val lastTradeId: String,
    @SerializedName("LASTUPDATE")
    val lastUpdate: Double,
    @SerializedName("LASTVOLUME")
    val lastVolume: Double,
    @SerializedName("LASTVOLUMETO")
    val lastVolumeTo: Double,
    @SerializedName("LOW24HOUR")
    val low24Hour: Double,
    @SerializedName("LOWDAY")
    val lowDay: Double,
    @SerializedName("LOWHOUR")
    val lowHour: Double,
    @SerializedName("MARKET")
    val market: String,
    @SerializedName("MEDIAN")
    val median: Double,
    @SerializedName("MKTCAP")
    val marketCap: Double,
    @SerializedName("OPEN24HOUR")
    val open24Hour: Double,
    @SerializedName("OPENDAY")
    val openDay: Double,
    @SerializedName("OPENHOUR")
    val openHour: Double,
    @SerializedName("PRICE")
    val price: Double,
    @SerializedName("SUPPLY")
    val supply: Double,
    @SerializedName("TOPTIERVOLUME24HOUR")
    val topTierVolume24Hour: Double,
    @SerializedName("TOPTIERVOLUME24HOURTO")
    val topTierVolume24HourTo: Double,
    @SerializedName("TOSYMBOL")
    val toSymbol: String,
    @SerializedName("TOTALTOPTIERVOLUME24H")
    val totaltopTierVolume24H: Double,
    @SerializedName("TOTALtoPTIERVOLUME24Hto")
    val totaltopTierVolume24HTo: Double,
    @SerializedName("TOTALVOLUME24H")
    val totalVolume24H: Double,
    @SerializedName("TOTALVOLUME24HTO")
    val totalVolume24HTo: Double,
    @SerializedName("TYPE")
    val type: String,
    @SerializedName("VOLUME24HOUR")
    val volume24Hour: Double,
    @SerializedName("VOLUME24HOURTO")
    val volume24HourTo: Double,
    @SerializedName("VOLUMEDAY")
    val volumeDay: Double,
    @SerializedName("VOLUMEDAYTO")
    val volumeDayTo: Double,
    @SerializedName("VOLUMEHOUR")
    val volumeHour: Double,
    @SerializedName("VOLUMEHOURTO")
    val volumeHourTo: Double
)