package bobby.irawan.ministockbit.presentation.wathclist.viewmodel

import bobby.irawan.ministockbit.domain.common.SimpleResult
import bobby.irawan.ministockbit.domain.model.CryptoModel
import bobby.irawan.ministockbit.domain.usecase.GetCryptoUseCase
import bobby.irawan.ministockbit.presentation.helper.BaseTest
import bobby.irawan.ministockbit.presentation.helper.MockData
import bobby.irawan.ministockbit.presentation.helper.ObserverHelper
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.verifySequence
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Created by bobbyirawan09 on 29/08/20.
 */
@ExperimentalCoroutinesApi
class WatchListViewModelTest : BaseTest() {

    @MockK
    private lateinit var mockUseCase: GetCryptoUseCase

    private lateinit var viewModel: WatchListViewModel

    override fun setup() {
        super.setup()

        viewModel = WatchListViewModel(mockUseCase)
    }

    @Test
    fun givenNotOnRefreshDataState_whenCallForCryptoData_shouldReturnCryptoData() {
        //Given
        val observer = ObserverHelper.getMockObserver<SimpleResult<List<CryptoModel>>>()
        viewModel.cryptoData.observeForever(observer)
        coEvery { mockUseCase.execute(MockData.request) } returns MockData.nonEmptyResult

        //When
        runBlocking {
            viewModel.getCryptoData(false)

            //Then
            verifySequence {
                observer.onChanged(viewModel.cryptoData.value)
            }
        }
    }

    @Test
    fun givenNotOnRefreshDataState_whenCallForCryptoData_shouldReturnEmptyData() {
//Given
        val observer = ObserverHelper.getMockObserver<SimpleResult<List<CryptoModel>>>()
        viewModel.cryptoData.observeForever(observer)
        coEvery { mockUseCase.execute(MockData.request) } returns MockData.emptyResult

        //When
        runBlocking {
            viewModel.getCryptoData(false)

            //Then
            verifySequence {
                observer.onChanged(viewModel.cryptoData.value)
            }
        }
    }
}