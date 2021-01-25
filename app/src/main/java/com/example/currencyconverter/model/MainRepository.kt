package com.example.currencyconverter.model

import com.example.currencyconverter.utils.Resource

interface MainRepository {
    suspend fun getRates(baseCurrency: String): Resource<CurrencyResponse>
}