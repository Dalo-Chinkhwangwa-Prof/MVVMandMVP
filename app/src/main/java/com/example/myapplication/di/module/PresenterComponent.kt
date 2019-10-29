package com.example.myapplication.di.module

import com.example.myapplication.view.MainActivity
import com.example.myapplication.view.MyProfileFragment
import dagger.Component

@Component(modules = [PresenterModule::class])
interface PresenterComponent {
    fun inject(mainActivity: MainActivity)
//    fun inject(myProfileFragment: MyProfileFragment)
}