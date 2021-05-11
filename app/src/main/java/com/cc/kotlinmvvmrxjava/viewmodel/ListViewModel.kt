package com.cc.kotlinmvvmrxjava.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.cc.kotlinmvvmrxjava.model.UserResponse
import com.cc.kotlinmvvmrxjava.model.db.UserDatabase
import com.cc.kotlinmvvmrxjava.model.network.Repository
import com.cc.kotlinmvvmrxjava.util.LogToConsole
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository()

    private val compositeDisposable = CompositeDisposable()
    //TODO clear where?

    fun getUserResponse () : LiveData<UserResponse?> {
        return repository.getUsers(getApplication())
    }

    fun loadUserResponse (context: Context, total:Int, nat:String) {
        compositeDisposable.add(repository.loadUserResponse(context, total, nat)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {response -> loadOnResponse(context, response)},
                {t ->  loadOnFail(t)}
            ))
    }

    private fun loadOnResponse (context: Context, response:UserResponse) {
        LogToConsole.log("subscribe , $response")

        viewModelScope.launch {
            repository.cacheUserResponse(context, response)

        }

    }

    private fun loadOnFail (t : Throwable) {
        LogToConsole.log("error , ${t.localizedMessage}")

    }




}