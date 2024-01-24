package com.example.appforcertificate.di

import com.example.appforcertificate.data.api.ConvertApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
fun provideConvertApi(retrofit: Retrofit) = retrofit.create(ConvertApi::class.java)

}