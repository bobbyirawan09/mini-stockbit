package bobby.irawan.ministockbit.domain.common

/**
 * Created by bobbyirawan09 on 25/08/20.
 */

sealed class Result<out Data, out Error> {
    sealed class Success<T> : Result<T, Nothing>() {
        class Data<T>(val data: T) : Success<T>()
        object NoData : Success<Nothing>()
    }

    class Failure<out R : Error>(val errorData: R) : Result<Nothing, R>()

    sealed class State : Result<Nothing, Nothing>() {
        object Initial : State()
        object Loading : State()
        object NoInternet : State()
    }

    fun handleResult(
        successDataBlock: (Data) -> Unit = {},
        successNoDataBlock: () -> Unit = {},
        failureBlock: (Error) -> Unit = {},
        stateBlock: (State) -> Unit = {}
    ) {
        when (this) {
            is Success.Data -> successDataBlock(this.data)
            is Success.NoData -> successNoDataBlock()
            is Failure -> failureBlock(errorData)
            is State -> stateBlock(this)
        }
    }

    fun <MappedData> mapData(
        map: (data: Data) -> Success<MappedData>
    ): Result<MappedData, Error> {
        return when (this) {
            is Success.Data -> map(this.data)
            is Success.NoData -> this
            is Failure -> this
            is State -> this
        }
    }
}