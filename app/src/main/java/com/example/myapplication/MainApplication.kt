package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.DaggerGitComponent
import com.example.myapplication.di.module.DaggerPresenterComponent
import com.example.myapplication.util.ApplicationData

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ApplicationData.daggerGitComponent = DaggerGitComponent.create()
        ApplicationData.daggerPresenterComponent = DaggerPresenterComponent.create()
    }
}