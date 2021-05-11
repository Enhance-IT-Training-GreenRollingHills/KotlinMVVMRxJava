package com.cc.kotlinmvvmrxjava.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Timezone(
    @PrimaryKey (autoGenerate = true)
    val id:Int,
    val description: String,
    val offset: String
)