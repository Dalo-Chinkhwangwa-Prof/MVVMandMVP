package com.example.myapplication.presenter

import com.example.myapplication.model.RepoResponse
import com.example.myapplication.model.UserResponse
import io.reactivex.Observable

interface PresenterContract{

    interface GitRepoPresenter{
        fun getRepositories(): Observable<List<RepoResponse>>
        fun setRepoView(repoView: GitRepoView)
    }

    interface GitUserPresenter{
        fun getUser(): Observable<UserResponse>
        fun setUserView(userView: GitUserView)
    }

    interface GitRepoView{
        fun callFailed()
    }
    interface GitUserView{
        fun callFailed()
    }

}