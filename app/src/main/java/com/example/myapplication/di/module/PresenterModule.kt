package com.example.myapplication.di.module

import com.example.myapplication.presenter.GitRepositoryPresenter
import com.example.myapplication.presenter.GitUserPresenter
import com.example.myapplication.presenter.PresenterContract
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun providesGitRepoPresenter(): PresenterContract.GitRepoPresenter {
        return GitRepositoryPresenter()
    }

    @Provides
    fun providesGitUserPresenter(): PresenterContract.GitUserPresenter {
        return GitUserPresenter()
    }
}