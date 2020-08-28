package bobby.irawan.ministockbit.domain.di

import bobby.irawan.ministockbit.data.CryptoRepositoryImpl
import bobby.irawan.ministockbit.data.mapper.CryptoMapper
import bobby.irawan.ministockbit.data.mapper.WebSocketMapper
import bobby.irawan.ministockbit.data.service.CryptoAPI
import bobby.irawan.ministockbit.data.service.WebSocketApi
import bobby.irawan.ministockbit.domain.repository.CryptoRepository
import com.tinder.scarlet.Scarlet
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by bobbyirawan09 on 25/08/20.
 */

val dataModule = module {

    single { get<Retrofit>().create(CryptoAPI::class.java) }

    single<CryptoRepository> {
        CryptoRepositoryImpl(get(), get(), get(), get())
    }

    single {
        get<Scarlet>().create(WebSocketApi::class.java)
    }

    single {
        CryptoMapper()
    }

    single {
        WebSocketMapper()
    }
}