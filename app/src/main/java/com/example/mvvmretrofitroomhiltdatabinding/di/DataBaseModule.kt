package com.example.mvvmretrofitroomhiltdatabinding.di

import android.content.Context
import androidx.room.Room
import com.example.mvvmretrofitroomhiltdatabinding.dao.UniversityDAO
import com.example.mvvmretrofitroomhiltdatabinding.roomdatabase.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val dbName = "universityDB.db"
@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {


    @Provides
    fun provideUniversityDAO(roomDB : AppDatabase) : UniversityDAO{
        return  roomDB.getUniversityDAO()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context : Context) : AppDatabase{
        return Room.databaseBuilder(context,AppDatabase::class.java, dbName).build()
    }
}