package com.example.myapplication.util
import com.example.myapplication.di.GitComponent
import com.example.myapplication.di.module.PresenterComponent

object ApplicationData {
    var daggerGitComponent: GitComponent? = null
    var daggerPresenterComponent: PresenterComponent? = null
}