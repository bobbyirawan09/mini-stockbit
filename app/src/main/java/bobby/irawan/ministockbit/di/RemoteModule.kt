package bobby.irawan.ministockbit.di

import bobby.irawan.ministockbit.BuildConfig.*
import bobby.irawan.ministockbit.data.common.RetrofitFactory
import bobby.irawan.ministockbit.data.common.ScarletFactory
import org.koin.dsl.module

/**
 * Created by bobbyirawan09 on 25/08/20.
 */

val remoteModule = module {
    single {
        RetrofitFactory.create(BASE_URL, API_KEY)
    }
    single {
        ScarletFactory.create(BASE_URL_WEBSOCKET, API_KEY)
    }
}