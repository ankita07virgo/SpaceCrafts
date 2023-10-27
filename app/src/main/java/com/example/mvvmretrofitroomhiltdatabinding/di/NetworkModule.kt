package com.example.mvvmretrofitroomhiltdatabinding.di

import com.example.mvvmretrofitroomhiltdatabinding.retrofit.UniversityAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl("http://universities.hipolabs.com/").addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun providesRetrofitAPI(retrofit: Retrofit) : UniversityAPI{
        return retrofit.create(UniversityAPI::class.java)
    }
}