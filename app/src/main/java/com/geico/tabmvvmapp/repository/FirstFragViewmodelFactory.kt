package com.geico.tabmvvmapp.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.geico.tabmvvmapp.viewmodel.FirstFragViewmodel

class FirstFragViewmodelFactory(private val userRepository: FirstUserRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return FirstFragViewmodel(userRepository) as T
    }
}