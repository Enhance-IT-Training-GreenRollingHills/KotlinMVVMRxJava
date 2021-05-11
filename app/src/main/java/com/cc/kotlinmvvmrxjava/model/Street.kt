package com.cc.kotlinmvvmrxjava.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.IDN

@Entity
data class Street(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val number:Int,
    val name:String
)


