package com.cc.kotlinmvvmrxjava.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.cc.kotlinmvvmrxjava.model.*
import java.util.*


@Database(entities =
[UserResponse::class, Timezone::class, Result::class, Registered::class, Picture::class, Name::class, Login::class, Location::class, Info::class,
Id::class, Dob::class, Coordinates::class, Street::class],
    version = 4, exportSchema = false)
@TypeConverters(Converter::class)
abstract class UserDatabase : RoomDatabase() {

    abstract val userDao:UserDao

    companion object {
        //instance

        @Volatile
        private var INSTANCE : UserDatabase? = null

        fun getInstance(context: Context):UserDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = buildInstance(context)
                    INSTANCE = instance
                }
                return instance
            }


        }


        //buildInstance
        private fun buildInstance (context: Context) = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "databaseName")
            .fallbackToDestructiveMigration()
            .build()
    }






}