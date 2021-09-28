package com.example.listwithpaging.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retronstance {

    companion object {
        val baseUrl = "https://rickandmortyapi.com/api/"

        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}