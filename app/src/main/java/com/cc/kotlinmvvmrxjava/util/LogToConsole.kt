package com.cc.kotlinmvvmrxjava.util

import android.util.Log

class LogToConsole {

    companion object {
        fun log (msg:String) {
            Log.d("TAG_X", msg)
        }
    }

}