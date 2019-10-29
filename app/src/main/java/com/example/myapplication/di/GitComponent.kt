package com.example.myapplication.di

import com.example.myapplication.di.module.GitModule
import com.example.myapplication.presenter.GitRepositoryPresenter
import com.example.myapplication.presenter.GitUserPresenter
import com.example.myapplication.viewmodel.MainViewModel
import dagger.Component

@Component(modules = [GitModule::class])
interface GitComponent{
    fun inject(gitRepoPresenter: GitRepositoryPresenter)
//    fun inject(gitUserPresenter: GitUserPresenter)
    fun inject(viewModel: MainViewModel)
}