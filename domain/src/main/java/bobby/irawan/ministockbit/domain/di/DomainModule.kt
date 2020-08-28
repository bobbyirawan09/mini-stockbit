package bobby.irawan.ministockbit.domain.di

import bobby.irawan.ministockbit.domain.usecase.GetCryptoUseCase
import bobby.irawan.ministockbit.domain.usecase.GetWebSocketUseCase
import org.koin.dsl.module

/**
 * Created by bobbyirawan09 on 25/08/20.
 */

val domainModule = module {
    single {
        GetCryptoUseCase(get())
    }

    single {
        GetWebSocketUseCase(get())
    }
}