package com.example.mvvmretrofitroomhiltdatabinding.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmretrofitroomhiltdatabinding.modal.University

@Dao
interface UniversityDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUniversity(universityList : List<University>?)

    @Query("Select * from university_table")
    fun getUniversityList() : LiveData<List<University>>
}