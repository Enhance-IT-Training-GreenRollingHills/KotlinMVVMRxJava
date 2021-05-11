package com.cc.kotlinmvvmrxjava.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Registered(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val age: Int,
    val date: String
)