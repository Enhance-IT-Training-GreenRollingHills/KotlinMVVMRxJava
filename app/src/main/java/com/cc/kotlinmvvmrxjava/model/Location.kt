package com.cc.kotlinmvvmrxjava.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Location(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val city: String,
    val coordinates: Coordinates,
    val postcode: String,
    val state: String,
    val street: Street,
    val timezone: Timezone
)