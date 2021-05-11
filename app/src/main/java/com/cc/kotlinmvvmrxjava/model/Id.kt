package com.cc.kotlinmvvmrxjava.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Id(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name: String,
    val value: String
)