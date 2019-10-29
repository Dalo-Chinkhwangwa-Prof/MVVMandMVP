package com.example.myapplication.di.module

import com.example.myapplication.factory.GitFactory
import dagger.Module
import dagger.Provides

@Module
class GitModule {
    @Provides
    fun providesGitFactory(): GitFactory {
        return GitFactory()
    }
}