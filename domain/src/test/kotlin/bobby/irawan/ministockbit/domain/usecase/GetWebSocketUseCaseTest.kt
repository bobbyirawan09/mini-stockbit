package bobby.irawan.ministockbit.domain.usecase

import bobby.irawan.domain.helper.BaseTest
import bobby.irawan.domain.helper.MockData
import bobby.irawan.ministockbit.domain.model.WebSocketModel
import bobby.irawan.ministockbit.domain.repository.CryptoRepository
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test

/**
 * Created by bobbyirawan09 on 29/08/20.
 */
@ExperimentalCoroutinesApi
class GetWebSocketUseCaseTest : BaseTest() {
    @MockK
    private lateinit var mockRepository: CryptoRepository

    private lateinit var useCase: GetWebSocketUseCase

    override fun setup() {
        super.setup()

        useCase = GetWebSocketUseCase(mockRepository)
    }

    @Test
    fun givenCallState_whenCallRepositoryGetWebSocketData_shouldReturnWebSocketResult() {
        //Given
        val result = MockData.webSocketModel
        coEvery { mockRepository.getWebSocketData() } returns flowOf(MockData.webSocketModel)

        runBlockingTest {
            //When
            var response = WebSocketModel()
            mockRepository.getWebSocketData().collect {
                response = it
            }

            //Then
            Assert.assertEquals(result, response)
        }
    }

    @Test
    fun givenCallState_whenCallRepositoryGetWebSocketData_shouldReturnErrorResult() {
        //Given
        val result = MockData.errorWebSocketModel
        coEvery { mockRepository.getWebSocketData() } returns flowOf(MockData.errorWebSocketModel)

        runBlockingTest {
            //When
            var response = WebSocketModel()
            mockRepository.getWebSocketData().collect {
                response = it
            }

            //Then
            Assert.assertEquals(result, response)
        }
    }
}