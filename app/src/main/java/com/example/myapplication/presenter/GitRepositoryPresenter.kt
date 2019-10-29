package com.example.myapplication.presenter

import com.example.myapplication.factory.GitFactory
import com.example.myapplication.model.RepoResponse
import com.example.myapplication.util.ApplicationData.daggerGitComponent
import io.reactivex.Observable
import javax.inject.Inject


class GitRepositoryPresenter : PresenterContract.GitRepoPresenter {


    @Inject
    lateinit var gitFactory: GitFactory

    init {
        daggerGitComponent?.inject(this)
    }

    private lateinit var repoView: PresenterContract.GitRepoView

    override fun setRepoView(repoView: PresenterContract.GitRepoView) {
        this.repoView = repoView
    }


    override fun getRepositories(): Observable<List<RepoResponse>> {
        return gitFactory.getGitRepositories("Dalo-Chinkhwangwa-Prof")
    }

}