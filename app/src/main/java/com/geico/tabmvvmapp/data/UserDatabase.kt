package com.geico.tabmvvmapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.geico.tabmvvmapp.model.FirstUsers

@Database(entities = [FirstUsers::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun firstUserDao() :FirstUsersDao

    companion object{
        private var INSTANCE : UserDatabase? = null

        fun getDatabase(context:Context):UserDatabase{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context,
                        UserDatabase::class.java,
                        "user_database"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}