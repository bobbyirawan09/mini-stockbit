package bobby.irawan.ministockbit.domain.usecase

import bobby.irawan.domain.helper.BaseTest
import bobby.irawan.domain.helper.MockData
import bobby.irawan.ministockbit.domain.repository.CryptoRepository
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by bobbyirawan09 on 29/08/20.
 */
@ExperimentalCoroutinesApi
class GetCryptoUseCaseTest : BaseTest() {

    @MockK
    private lateinit var mockRepository: CryptoRepository

    private lateinit var useCase: GetCryptoUseCase

    override fun setup() {
        super.setup()

        useCase = GetCryptoUseCase(mockRepository)
    }

    @Test
    fun givenRequestModel_whenCallRepositoryGetCryptoData_shouldReturnCryptoResult() {
        //Given
        val result = MockData.nonEmptyResult
        coEvery { mockRepository.getCryptoData(MockData.request) } returns MockData.nonEmptyResult

        runBlockingTest {
            //When
            val response = mockRepository.getCryptoData(MockData.request)

            //Then
            assertEquals(result, response)
        }
    }

    @Test
    fun givenRequestModel_whenCallRepositoryGetCryptoData_shouldReturnEmptyResult() {
        //Given
        val result = MockData.emptyResult
        coEvery { mockRepository.getCryptoData(MockData.request) } returns MockData.emptyResult

        runBlockingTest {
            //When
            val response = mockRepository.getCryptoData(MockData.request)

            //Then
            assertEquals(result, response)
        }
    }
}