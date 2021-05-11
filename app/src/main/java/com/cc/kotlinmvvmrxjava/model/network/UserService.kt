package com.cc.kotlinmvvmrxjava.model.network

import com.cc.kotlinmvvmrxjava.model.UserResponse
import com.cc.kotlinmvvmrxjava.util.Constants
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET(Constants.endPoint)
    fun getUsers(@Query(Constants.resultsQuery) total:Int, @Query(Constants.natQuery) nat:String) : Single<UserResponse>



}