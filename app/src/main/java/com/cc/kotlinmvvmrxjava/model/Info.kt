package com.cc.kotlinmvvmrxjava.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Info(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)