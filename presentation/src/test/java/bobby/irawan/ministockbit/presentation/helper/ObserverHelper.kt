package bobby.irawan.ministockbit.presentation.helper

import androidx.lifecycle.Observer
import io.mockk.spyk

/**
 * Created by bobbyirawan09 on 29/08/20.
 */
object ObserverHelper {
    fun <T> getMockObserver(): Observer<T> = spyk(Observer { })
}