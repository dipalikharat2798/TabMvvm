package com.geico.tabmvvmapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "firstUser")
data class FirstUsers(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name:String,
    val lastName:String,
    val pass : String
)
