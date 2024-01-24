package com.example.appforcertificate.di

import com.example.appforcertificate.data.repo.ConvertRepoImpl
import com.example.appforcertificate.domain.repo.ConvertRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindConvertRepo(
        convertRepoImpl: ConvertRepoImpl
    ): ConvertRepo

}