package com.example.mvvmretrofitroomhiltdatabinding.retrofit

import com.example.mvvmretrofitroomhiltdatabinding.modal.University
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversityAPI {

    @GET("search")
    suspend fun getAllUniversity(@Query("country") country : String) : Response<List<University>>
}