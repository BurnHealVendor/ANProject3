package com.example.anproject3.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(
    private val applicationContext: Context
) {
    @Provides
    fun providesAppContext(): Context  = applicationContext
}