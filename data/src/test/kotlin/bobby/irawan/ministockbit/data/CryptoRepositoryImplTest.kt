package bobby.irawan.ministockbit.data

import bobby.irawan.helper.BaseTest
import bobby.irawan.helper.MockData
import bobby.irawan.helper.MockData.baseResponse
import bobby.irawan.helper.MockData.cryptoList
import bobby.irawan.helper.MockData.cryptoResponse
import bobby.irawan.helper.MockData.limit
import bobby.irawan.helper.MockData.page
import bobby.irawan.helper.MockData.requestParam
import bobby.irawan.helper.MockData.tsym
import bobby.irawan.ministockbit.data.mapper.CryptoMapper
import bobby.irawan.ministockbit.data.mapper.WebSocketMapper
import bobby.irawan.ministockbit.data.service.CryptoAPI
import bobby.irawan.ministockbit.data.service.WebSocketApi
import bobby.irawan.ministockbit.domain.common.Result
import bobby.irawan.ministockbit.domain.model.WebSocketModel
import bobby.irawan.ministockbit.domain.repository.CryptoRepository
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import retrofit2.Response

/**
 * Created by bobbyirawan09 on 29/08/20.
 */
@ExperimentalCoroutinesApi
class CryptoRepositoryImplTest : BaseTest() {

    @MockK
    private lateinit var api: CryptoAPI

    @MockK
    private lateinit var cryptoMapper: CryptoMapper

    @MockK(relaxUnitFun = true)
    private lateinit var webSocketMapper: WebSocketMapper

    @MockK
    private lateinit var webSocket: WebSocketApi

    private lateinit var repositoryImpl: CryptoRepository

    override fun setup() {
        super.setup()

        repositoryImpl = CryptoRepositoryImpl(api, cryptoMapper, webSocketMapper, webSocket)
    }

    @Test
    fun givenNonEmptyResult_whenGetCryptoData_shouldReturnCryptoData() {
        //Given
        val successResponse = baseResponse
        successResponse.data = listOf(cryptoResponse, cryptoResponse)
        coEvery { cryptoMapper.mapFromResponse(any()) } returns cryptoList
        coEvery {
            api.getCryptoData(
                limit,
                page,
                tsym
            )
        } returns Response.success(successResponse)

        runBlockingTest {
            // When
            val result = repositoryImpl.getCryptoData(requestParam)
            // Then
            assert(
                result is Result.Success.Data
            )
        }
    }

    @Test
    fun givenEmptyResult_whenGetCryptoData_shouldReturnEmptyData() {
        val successResponse = baseResponse
        successResponse.data = listOf()
        coEvery { cryptoMapper.mapFromResponse(any()) } returns cryptoList
        coEvery {
            api.getCryptoData(
                limit,
                page,
                tsym
            )
        } returns Response.success(successResponse)

        runBlockingTest {
            // When
            val result = repositoryImpl.getCryptoData(requestParam)
            // Then
            assert(
                result is Result.Success.Data
            )
        }
    }

    @Test
    fun givenNullResult_whenGetCryptoData_shouldReturnError() {
        //Given
        val successResponse = baseResponse
        successResponse.data = null
        coEvery { cryptoMapper.mapFromResponse(any()) } returns cryptoList
        coEvery {
            api.getCryptoData(
                limit,
                page,
                tsym
            )
        } returns Response.success(successResponse)

        runBlockingTest {
            // When
            val result = repositoryImpl.getCryptoData(requestParam)
            // Then
            assert(
                result is Result.Failure
            )
        }
    }

    @Test
    fun givenSubscribeModel_whenGetWebSocketData_shouldReturnWebSocketData() {
        //Given
        coEvery { webSocket.observeResponse() } returns flowOf(MockData.webSocketResponse)
        coEvery { webSocketMapper.mapFromResponse(any()) } returns MockData.webSocketModel

        runBlockingTest {
            //When
            var result = WebSocketModel()
            webSocket.observeResponse().collect { response ->
                result = webSocketMapper.mapFromResponse(response)
            }
            //Then
            assertEquals(MockData.webSocketModel, result)
        }
    }

    @Test
    fun givenSubscribeModel_whenGetWebSocketData_shouldReturnErrorData() {
        //Given
        coEvery { webSocket.observeResponse() } returns flowOf(MockData.errorWebSocketResponse)
        coEvery { webSocketMapper.mapFromResponse(any()) } returns MockData.errorWebSocketModel

        runBlockingTest {
            //When
            var result = WebSocketModel()
            webSocket.observeResponse().collect { response ->
                result = webSocketMapper.mapFromResponse(response)
            }
            //Then
            assertEquals(MockData.errorWebSocketModel, result)
        }
    }
}