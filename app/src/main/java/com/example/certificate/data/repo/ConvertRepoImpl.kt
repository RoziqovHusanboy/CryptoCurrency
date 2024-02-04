package com.example.appforcertificate.data.repo

import com.example.appforcertificate.data.api.ConvertApi
import com.example.appforcertificate.data.model.ConvertData
import com.example.appforcertificate.domain.repo.ConvertRepo
import javax.inject.Inject

class ConvertRepoImpl @Inject constructor(
    private val api: ConvertApi
):ConvertRepo {
    override suspend fun getConvert() = api.getConvert()
}