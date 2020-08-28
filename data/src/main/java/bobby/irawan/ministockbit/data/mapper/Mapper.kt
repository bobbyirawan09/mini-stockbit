package bobby.irawan.ministockbit.data.mapper

interface Mapper<Response, Model> {

    fun mapFromResponse(response: Response): Model
}
