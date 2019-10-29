package com.example.myapplication.presenter

import com.example.myapplication.factory.GitFactory
import com.example.myapplication.model.UserResponse
import com.example.myapplication.util.ApplicationData.daggerGitComponent
import io.reactivex.Observable
import javax.inject.Inject

class GitUserPresenter : PresenterContract.GitUserPresenter{

    @Inject
    lateinit var gitFactory: GitFactory

    private lateinit var userView:PresenterContract.GitUserView


    override fun setUserView(userView: PresenterContract.GitUserView) {
        this.userView = userView
    }

    init {
//        daggerGitComponent?.inject(this)
    }

    override fun getUser(): Observable<UserResponse> {
        return Observable.just(UserResponse())
//        return gitFactory.getGitUser("Dalo-Chinkhwangwa-Prof")
    }

}