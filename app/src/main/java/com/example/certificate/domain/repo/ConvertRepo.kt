package com.example.appforcertificate.domain.repo

import com.example.appforcertificate.data.model.ConvertData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ConvertRepo {
suspend fun getConvert():List<ConvertData>


}