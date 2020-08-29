package bobby.irawan.ministockbit.presentation.login.viewmodel

import bobby.irawan.ministockbit.presentation.helper.BaseTest
import bobby.irawan.ministockbit.presentation.helper.MockData
import bobby.irawan.ministockbit.presentation.helper.ObserverHelper
import bobby.irawan.ministockbit.presentation.utils.Constants.EMAIL
import bobby.irawan.ministockbit.presentation.utils.Constants.LoginFlow
import bobby.irawan.ministockbit.presentation.utils.UserManager
import io.mockk.*
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString

/**
 * Created by bobbyirawan09 on 29/08/20.
 */
@ExperimentalCoroutinesApi
class LoginViewModelTest : BaseTest() {

    @MockK(relaxUnitFun = true)
    private lateinit var mockUserManager: UserManager

    private lateinit var viewModel: LoginViewModel

    override fun setup() {
        super.setup()
        every { mockUserManager.startUserSession() } just Runs //Do nothing
        every { mockUserManager.setProperty(EMAIL) value anyString() } just runs
        every { mockUserManager.isSessionActive() } returns true
        viewModel = LoginViewModel(mockUserManager)
    }

    @Test
    fun givenFlowLoginToLoginPage_whenNavigate_shouldNavigateToLoginPage() {
        //Given
        val observer = ObserverHelper.getMockObserver<LoginFlow>()
        viewModel.loginFlow.observeForever(observer)
        val flow = LoginFlow.LoginPage

        //When
        viewModel.navigate(flow)

        //Then
        assertEquals(
            MockData.loginPageFlow, viewModel.loginFlow.value
        )
    }

    @Test
    fun givenFlowLoginToHomePage_whenNavigate_shouldNavigateToHomePage() {
        //Given
        val observer = ObserverHelper.getMockObserver<LoginFlow>()
        viewModel.loginFlow.observeForever(observer)
        val flow = LoginFlow.HomePage

        //When
        viewModel.navigate(flow)

        //Then
        assertEquals(
            MockData.homePageFlow, viewModel.loginFlow.value
        )
    }

    @Test
    fun giveUserEmail_whenUserLogin_shouldNavigateToHomePage() {
        //Given
        val observer = ObserverHelper.getMockObserver<LoginFlow>()
        viewModel.loginFlow.observeForever(observer)
        val observerSnackbar = ObserverHelper.getMockObserver<String>()
        viewModel.successSnackbar().observeForever(observerSnackbar)
        val email = "test@gmail.com"
        every { mockUserManager.email } returns email

        //When
        viewModel.onUserLogin(email)

        //Then
        verifySequence {
            observer.onChanged(viewModel.loginFlow.value)
            observerSnackbar.onChanged(viewModel.successSnackbar().value)
            observer.onChanged(viewModel.loginFlow.value)
        }
        assertEquals(
            email, mockUserManager.email
        )
    }
}