package com.cc.kotlinmvvmrxjava.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Name(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val first: String,
    val last: String,
    val title: String
)