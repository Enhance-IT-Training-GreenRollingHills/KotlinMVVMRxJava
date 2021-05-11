package com.cc.kotlinmvvmrxjava.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cc.kotlinmvvmrxjava.model.UserResponse

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUserResponses(vararg userResponses:UserResponse)

    @Query("SELECT * From UserResponse")
    fun getUserResponseLiveData() : LiveData<UserResponse?>

}