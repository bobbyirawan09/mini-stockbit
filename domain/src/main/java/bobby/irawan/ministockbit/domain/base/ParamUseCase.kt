package bobby.irawan.ministockbit.domain.base

import bobby.irawan.ministockbit.domain.common.SimpleResult

/**
 * Created by bobbyirawan09 on 26/08/20.
 */
abstract class ParamUseCase<in Param, T> {
    abstract suspend fun execute(param: Param): SimpleResult<T>
}