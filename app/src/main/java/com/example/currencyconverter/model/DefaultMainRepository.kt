package com.example.currencyconverter.model

import com.example.currencyconverter.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyApi
) : MainRepository {
    override suspend fun getRates(baseCurrency: String): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates(baseCurrency)
            val result = response.body()

            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An error has occurred")
        }
    }
}