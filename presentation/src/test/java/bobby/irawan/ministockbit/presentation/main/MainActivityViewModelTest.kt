package bobby.irawan.ministockbit.presentation.main

import bobby.irawan.ministockbit.presentation.helper.BaseTest
import bobby.irawan.ministockbit.presentation.helper.ObserverHelper
import bobby.irawan.ministockbit.presentation.login.viewmodel.LoginViewModel
import bobby.irawan.ministockbit.presentation.utils.Constants
import bobby.irawan.ministockbit.presentation.utils.UserManager
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test

import org.junit.Assert.*
import org.mockito.ArgumentMatchers

/**
 * Created by bobbyirawan09 on 29/08/20.
 */
@ExperimentalCoroutinesApi
class MainActivityViewModelTest: BaseTest() {

    @MockK(relaxUnitFun = true)
    private lateinit var mockUserManager: UserManager

    private lateinit var viewModel: MainActivityViewModel

    override fun setup() {
        super.setup()
        every { mockUserManager.endUserSession() } just Runs //Do nothing
        viewModel = MainActivityViewModel(mockUserManager)
    }

    @Test
    fun givenConditionUserLogout_whenUserLogin_shouldEndSessionAndLogoutUser() {
        //Given
        val observer = ObserverHelper.getMockObserver<String>()
        viewModel.successSnackbar().observeForever(observer)

        //When
        viewModel.onUserSignOut()

        //Then
        verifySequence {
            observer.onChanged(viewModel.successSnackbar().value)
        }
    }
}