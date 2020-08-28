package bobby.irawan.ministockbit.data.common

import bobby.irawan.ministockbit.data.model.BaseResponse
import retrofit2.Response

/**
 * Created by bobbyirawan09 on 26/08/20.
 */

typealias SimpleResponse<T> = Response<BaseResponse<T>>