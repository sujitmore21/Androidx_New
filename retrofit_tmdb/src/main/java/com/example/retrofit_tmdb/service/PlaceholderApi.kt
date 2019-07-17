package com.example.retrofit_tmdb.service

import com.example.retrofit_tmdb.data.PlaceholderPhotos
import com.example.retrofit_tmdb.data.PlaceholderPosts
import com.example.retrofit_tmdb.data.PlaceholderUsers
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface PlaceholderApi {

    @GET("/posts")
    fun getPosts() : Deferred<Response<List<PlaceholderPosts>>>

    @GET("/users")
    fun getUsers() : Deferred<Response<List<PlaceholderUsers>>>

    @GET("/photos")
    fun getPhotos() : Deferred<Response<List<PlaceholderPhotos>>>
}