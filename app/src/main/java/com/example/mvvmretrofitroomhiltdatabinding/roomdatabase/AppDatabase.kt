package com.example.mvvmretrofitroomhiltdatabinding.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mvvmretrofitroomhiltdatabinding.dao.UniversityDAO
import com.example.mvvmretrofitroomhiltdatabinding.modal.University

@TypeConverters(DataConverter::class)
@Database(entities = [University::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getUniversityDAO(): UniversityDAO
}