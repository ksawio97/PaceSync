package com.example.pacesync.presentation.core.di

import com.example.pacesync.presentation.core.managers.StagesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideStagesManager() : StagesManager {
        return StagesManager()
    }
}