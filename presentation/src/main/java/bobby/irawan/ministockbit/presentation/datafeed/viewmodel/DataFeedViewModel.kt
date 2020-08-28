package bobby.irawan.ministockbit.presentation.datafeed.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import bobby.irawan.ministockbit.domain.model.WebSocketModel
import bobby.irawan.ministockbit.domain.usecase.GetWebSocketUseCase
import bobby.irawan.ministockbit.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.collect

class DataFeedViewModel(private val getWebSocketUseCase: GetWebSocketUseCase) : BaseViewModel() {

    val webSocketData: LiveData<WebSocketModel> = liveData {
        getWebSocketUseCase.execute().collect { data ->
            emit(data)
        }
    }
}