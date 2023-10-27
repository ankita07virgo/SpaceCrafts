package com.example.mvvmretrofitroomhiltdatabinding.repository

import com.example.mvvmretrofitroomhiltdatabinding.dao.UniversityDAO
import com.example.mvvmretrofitroomhiltdatabinding.modal.University
import com.example.mvvmretrofitroomhiltdatabinding.retrofit.UniversityAPI
import javax.inject.Inject

class UniversityRepository @Inject constructor(private val universityAPI: UniversityAPI, private val universityDAO: UniversityDAO) {
    suspend fun getAllUniversity() = universityAPI.getAllUniversity("India")
    suspend fun insertUniversityList(universityList : List<University>?){
        universityDAO.insertUniversity(universityList)
    }
    fun getUniversityListDB()= universityDAO.getUniversityList()
}