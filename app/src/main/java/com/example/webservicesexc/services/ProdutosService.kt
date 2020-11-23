package com.example.webservicesexc.services

import com.example.webservicesexc.domain.Produto
import com.squareup.moshi.Json
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Repository {
    @GET("produtos")
    suspend fun getAllProdutos(): ArrayList<Produto>
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://promoios.com.br/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val repository: Repository = retrofit.create(Repository::class.java)