package bobby.irawan.ministockbit.domain.di

import android.content.SharedPreferences
import bobby.irawan.ministockbit.presentation.main.viewmodel.MainActivityViewModel
import bobby.irawan.ministockbit.presentation.datafeed.viewmodel.DataFeedViewModel
import bobby.irawan.ministockbit.presentation.login.viewmodel.LoginViewModel
import bobby.irawan.ministockbit.presentation.utils.Constants.SHARED_PREFERENCE_NAME
import bobby.irawan.ministockbit.presentation.utils.SharedPreferenceHelper
import bobby.irawan.ministockbit.presentation.utils.UserManager
import bobby.irawan.ministockbit.presentation.wathclist.viewmodel.WatchListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by bobbyirawan09 on 25/08/20.
 */

val presentationModule = module {

    viewModel {
        LoginViewModel(get())
    }

    viewModel {
        WatchListViewModel(get())
    }

    viewModel {
        MainActivityViewModel(
            get()
        )
    }

    viewModel {
        DataFeedViewModel(
            get()
        )
    }

    single<SharedPreferences> {
        androidApplication().getSharedPreferences(SHARED_PREFERENCE_NAME, 0)
    }

    single {
        SharedPreferenceHelper(get())
    }

    single {
        UserManager(get())
    }
}