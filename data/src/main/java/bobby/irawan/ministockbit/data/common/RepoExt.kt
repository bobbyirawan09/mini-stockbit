package bobby.irawan.ministockbit.data.common

import bobby.irawan.ministockbit.data.mapper.Mapper
import bobby.irawan.ministockbit.domain.common.Result
import bobby.irawan.ministockbit.domain.common.SimpleError
import bobby.irawan.ministockbit.domain.common.SimpleResult
import bobby.irawan.ministockbit.domain.model.WebSocketModel
import com.sun.org.apache.xpath.internal.operations.Mod
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.consume
import kotlinx.coroutines.channels.consumeEach
import java.lang.Exception

/**
 * Created by bobbyirawan09 on 26/08/20.
 */

fun <Response, Model> SimpleResponse<Response>.mapToResult(mapper: Mapper<Response, Model>): SimpleResult<Model> {
    return when {
        this.isSuccessful -> {
            val body = this.body()
            when {
                body?.data != null -> {
                    val mappedResult = mapper.mapFromResponse(body.data!!)
                    Result.Success.Data<Model>(mappedResult)
                }
                body?.message.equals("Success") -> {
                    Result.Success.NoData
                }
                else -> {
                    Result.Failure(SimpleError("Success but unknown failure"))
                }
            }
        }
        else -> Result.Failure(SimpleError(this.errorBody()?.string().orEmpty()))
    }
}