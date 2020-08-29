package bobby.irawan.domain.helper

import io.mockk.MockKAnnotations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before

/**
 * Created by bobbyirawan09 on 29/08/20.
 */
@ExperimentalCoroutinesApi
abstract class BaseTest {

    private val dispatchers = TestCoroutineDispatcher()

    @Before
    open fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(dispatchers)
    }

    @After
    open fun tearDown() {
        Dispatchers.resetMain()
    }
}