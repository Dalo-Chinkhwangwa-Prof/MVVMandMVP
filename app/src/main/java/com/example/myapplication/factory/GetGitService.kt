package com.example.myapplication.factory

import com.example.myapplication.model.RepoResponse
import com.example.myapplication.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GetGitService{
    @GET("users/{user_name}")
    fun getGitUser(@Path("user_name") gitUserName: String): Observable<UserResponse>

    @GET("users/{user_name}/repos")
    fun getUserRepos(@Path("user_name") gitUserName: String): Observable<List<RepoResponse>>
}