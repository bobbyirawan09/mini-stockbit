package bobby.irawan.presentation.schedulers

import com.androchef.domain.executor.ThreadExecutor
import io.reactivex.schedulers.Schedulers

class TestingThreadExecutor : ThreadExecutor {
    override fun execute(command: Runnable?) {
        Schedulers.trampoline().scheduleDirect(command!!)
    }
}
