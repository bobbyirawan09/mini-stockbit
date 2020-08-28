package bobby.irawan.ministockbit.data.service

import bobby.irawan.ministockbit.data.common.Constants.QUERY_PARAM_LIMIT
import bobby.irawan.ministockbit.data.common.Constants.QUERY_PARAM_PAGE
import bobby.irawan.ministockbit.data.common.Constants.QUERY_PARAM_TSYM
import bobby.irawan.ministockbit.data.common.SimpleResponse
import bobby.irawan.ministockbit.data.model.CryptoResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by bobbyirawan09 on 25/08/20.
 */
interface CryptoAPI {

    @GET("data/top/totaltoptiervolfull")
    suspend fun getCryptoData(
        @Query(QUERY_PARAM_LIMIT) limit: Int,
        @Query(QUERY_PARAM_PAGE) pageNum: Int,
        @Query(QUERY_PARAM_TSYM) tsym: String
    ): SimpleResponse<List<CryptoResponse>>


}