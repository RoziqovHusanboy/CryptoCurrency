package com.example.appforcertificate.data.api

import com.example.appforcertificate.data.model.ConvertData
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ConvertApi {

    @GET("uz/arkhiv-kursov-valyut/json/")
    suspend fun getConvert():List<ConvertData>

}