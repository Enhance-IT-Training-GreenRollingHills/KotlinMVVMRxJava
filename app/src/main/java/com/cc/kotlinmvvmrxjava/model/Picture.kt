package com.cc.kotlinmvvmrxjava.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Picture(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val large: String,
    val medium: String,
    val thumbnail: String
)