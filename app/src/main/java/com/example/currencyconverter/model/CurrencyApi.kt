package com.example.currencyconverter.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {
    @GET("latest")
    suspend fun getRates(
        @Query("base") baseCurrency: String
    ): Response<CurrencyResponse>
}