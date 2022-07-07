package com.geico.tabmvvmapp.repository

import androidx.lifecycle.LiveData
import com.geico.tabmvvmapp.model.FirstUsers
import com.geico.tabmvvmapp.data.FirstUsersDao

class FirstUserRepository(private val usersDao: FirstUsersDao) {

    fun getUsersData():LiveData<List<FirstUsers>>{
        return usersDao.getAllUsers()
    }

    fun insertUsers(firstUsers: FirstUsers){
        usersDao.insertUser(firstUsers)
    }

    fun deleteUsers(firstUsers: FirstUsers){
        usersDao.deleteUser(firstUsers)
    }
}