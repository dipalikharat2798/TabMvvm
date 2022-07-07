package com.geico.tabmvvmapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.geico.tabmvvmapp.model.FirstUsers

@Dao
interface FirstUsersDao {

    @Insert
    fun insertUser(firstUsers: FirstUsers)

    @Delete
    fun deleteUser(firstUsers: FirstUsers)

    @Query("SELECT * from firstUser")
    fun getAllUsers():LiveData<List<FirstUsers>>
}