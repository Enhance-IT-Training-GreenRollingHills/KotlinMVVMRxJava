package com.cc.kotlinmvvmrxjava.model.network

import android.content.Context
import androidx.lifecycle.LiveData
import com.cc.kotlinmvvmrxjava.model.UserResponse
import com.cc.kotlinmvvmrxjava.model.db.UserDatabase
import com.cc.kotlinmvvmrxjava.util.Constants
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class Repository {

    private val service = createRetrofit().create(UserService::class.java)


    private fun createRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


    fun getUsers (context: Context) : LiveData<UserResponse?> {
        val db = UserDatabase.getInstance(context)
        return db.userDao.getUserResponseLiveData()

    }

    /*fun loadUserResponse(context: Context, nat:String) {
        compositeDisposable.add(service.getUsers(nat)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {response -> loadOnResponse(context, response)},
                {t -> loadOnFail(t)})
        )

    }*/

    fun loadUserResponse(context: Context, total:Int, nat: String) : Single<UserResponse> {
        return service.getUsers(total, nat)
    }

    suspend fun cacheUserResponse (context: Context, response: UserResponse) {
        val db = UserDatabase.getInstance(context)
        db.userDao.insertAllUserResponses(response)
    }



}