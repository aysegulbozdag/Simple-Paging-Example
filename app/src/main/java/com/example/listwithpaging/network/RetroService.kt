package com.example.listwithpaging.network

import com.example.listwithpaging.model.RickyAndMortList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("character")
    suspend fun getDataFromApi(@Query("page") page: Int): RickyAndMortList
}