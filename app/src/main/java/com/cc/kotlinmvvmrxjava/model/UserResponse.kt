package com.cc.kotlinmvvmrxjava.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cc.kotlinmvvmrxjava.model.Info
import com.cc.kotlinmvvmrxjava.model.Result

@Entity
data class UserResponse(
    @PrimaryKey
    val id: Int = 1,
    val info: Info,
    val results: List<Result>
)