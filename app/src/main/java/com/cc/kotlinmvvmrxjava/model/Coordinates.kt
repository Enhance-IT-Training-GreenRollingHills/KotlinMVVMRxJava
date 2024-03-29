package com.cc.kotlinmvvmrxjava.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Coordinates(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val latitude: String,
    val longitude: String
)