package com.geico.tabmvvmapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geico.tabmvvmapp.repository.FirstUserRepository
import com.geico.tabmvvmapp.model.FirstUsers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstFragViewmodel(private val userRepository: FirstUserRepository) : ViewModel() {
   private val TAG = "FirstFragmentViewModel"

    fun getUserData():LiveData<List<FirstUsers>>{
        return userRepository.getUsersData()
    }

    fun insertUserData(firstUsers: FirstUsers){
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.insertUsers(firstUsers)
        }
    }
}