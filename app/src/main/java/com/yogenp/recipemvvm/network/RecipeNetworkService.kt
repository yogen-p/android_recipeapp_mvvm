package com.yogenp.recipemvvm.network

import com.yogenp.recipemvvm.network.model.RecipeNetworkEntity
import com.yogenp.recipemvvm.network.responses.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeNetworkService {

    @GET("search")
    suspend fun search(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): RecipeSearchResponse

    @GET("get")
    suspend fun getById(
        @Header("Authorization") token: String,
        @Query("id") id: Int
    ): RecipeNetworkEntity
}