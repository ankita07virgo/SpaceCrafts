package com.example.mvvmretrofitroomhiltdatabinding.viemodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmretrofitroomhiltdatabinding.modal.University
import com.example.mvvmretrofitroomhiltdatabinding.repository.UniversityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UniversityListViewModel @Inject constructor(private val universityRepository: UniversityRepository)  : ViewModel(){
    var errorMessage = MutableLiveData<String>()
    var loading = MutableLiveData<Boolean>()
    var result = MutableLiveData<List<University>>()
    private val navigateToUniversityDetailFragmentMutableLiveData = MutableLiveData<Boolean>()
    var navigateToUniversityDetailFragmentLiveData : LiveData<Boolean> = navigateToUniversityDetailFragmentMutableLiveData

    init {
        getAllUniversities()
    }

    private fun getAllUniversities() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = universityRepository.getAllUniversity()
            if(response.isSuccessful){
                loading.postValue(false)
                delay(5000)
                insertUniversityListDB(response.body())
               // result.postValue(response.body())
            }
            else
            {
                loading.postValue(false)
                errorMessage.postValue(response.message())
            }
        }
    }

    private suspend fun insertUniversityListDB(universityList : List<University>?) = universityRepository.insertUniversityList(universityList)
    fun getUniversityListDB()  = universityRepository.getUniversityListDB()

    fun navigateToUniversityDetail(){
        navigateToUniversityDetailFragmentMutableLiveData.value = true
    }
}