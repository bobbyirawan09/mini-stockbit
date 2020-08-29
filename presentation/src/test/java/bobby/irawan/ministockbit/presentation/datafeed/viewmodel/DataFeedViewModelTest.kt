package bobby.irawan.ministockbit.presentation.datafeed.viewmodel

import bobby.irawan.ministockbit.domain.model.WebSocketModel
import bobby.irawan.ministockbit.domain.usecase.GetWebSocketUseCase
import bobby.irawan.ministockbit.presentation.helper.BaseTest
import bobby.irawan.ministockbit.presentation.helper.MockData
import bobby.irawan.ministockbit.presentation.helper.ObserverHelper
import bobby.irawan.ministockbit.presentation.login.viewmodel.LoginViewModel
import bobby.irawan.ministockbit.presentation.utils.Constants
import bobby.irawan.ministockbit.presentation.utils.UserManager
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

import org.junit.Assert.*
import org.mockito.ArgumentMatchers

/**
 * Created by bobbyirawan09 on 29/08/20.
 */
@ExperimentalCoroutinesApi
class DataFeedViewModelTest: BaseTest() {

    @MockK
    private lateinit var mockUseCase: GetWebSocketUseCase

    private lateinit var viewModel: DataFeedViewModel

    override fun setup() {
        super.setup()

        coEvery { mockUseCase.execute() } returns flowOf(MockData.webSocketModel)
        viewModel = DataFeedViewModel(mockUseCase)
    }

    @Test
    fun givenUserOnPageDataFeed_whenConnectedToApi_shouldReturnResult() {
        //Given
        val observer = ObserverHelper.getMockObserver<WebSocketModel>()
        viewModel.webSocketData.observeForever(observer)

        //When
        //Nothing because the call is inline with livedata property

        //Then
        verifySequence {
            observer.onChanged(viewModel.webSocketData.value)
        }
        assertEquals(MockData.webSocketModel, viewModel.webSocketData.value)
    }
}