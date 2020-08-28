package bobby.irawan.ministockbit.domain.common

data class SimpleError(
    var errorMessage: String = ""
) : Error()