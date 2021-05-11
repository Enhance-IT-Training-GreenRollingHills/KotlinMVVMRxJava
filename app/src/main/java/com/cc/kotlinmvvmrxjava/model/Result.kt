package com.cc.kotlinmvvmrxjava.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cc.kotlinmvvmrxjava.model.*

@Entity
data class Result(
    @PrimaryKey (autoGenerate = true)
    val uniqueID:Int,
    val cell: String,
    val dob: Dob,
    val email: String,
    val gender: String,
    val id: Id,
    val location: Location,
    val login: Login,
    val name: Name,
    val nat: String,
    val phone: String,
    val picture: Picture,
    val registered: Registered
)