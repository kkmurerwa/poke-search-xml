package com.murerwa.pokesearchxml.di

import com.murerwa.pokesearchxml.network.repositories.AppRepository
import com.murerwa.pokesearchxml.network.repositories.AppRepositoryImpl
import com.murerwa.pokesearchxml.network.resources.Constants
import com.murerwa.pokesearchxml.network.retrofit.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePokemonApi(): PokemonApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAppRepository(api: PokemonApi): AppRepository {
        return AppRepositoryImpl(api)
    }
}