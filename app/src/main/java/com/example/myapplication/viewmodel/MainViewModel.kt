package com.example.myapplication.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.factory.GitFactory
import com.example.myapplication.model.RepoResponse
import com.example.myapplication.model.UserResponse
import com.example.myapplication.util.ApplicationData.daggerGitComponent
import io.reactivex.Observable
import javax.inject.Inject

class MainViewModel(application: Application): AndroidViewModel(application){

    @Inject
    lateinit var gitFactory: GitFactory


    init {
        Log.d("TAG_X", "ViewModel created")
        daggerGitComponent?.inject(this)
    }


    fun getUser(): Observable<UserResponse> {

        return gitFactory.getGitUser("Dalo-Chinkhwangwa-Prof")
    }

    fun getRepositories(): Observable<List<RepoResponse>> {
        return gitFactory.getGitRepositories("Dalo-Chinkhwangwa-Prof")
    }
}