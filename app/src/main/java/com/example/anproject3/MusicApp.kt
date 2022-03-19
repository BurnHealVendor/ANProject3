package com.example.anproject3

import android.app.Application
import com.example.anproject3.di.ApplicationModule
import com.example.anproject3.di.MusicComponent
import com.example.anproject3.di.NetworkModule
import com.example.anproject3.di.PresentersModule

class MusicApp : Application() {
    override fun onCreate() {
        super.onCreate()

        musicComponent = DaggerMusicComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .networkModule(NetworkModule())
            .presentersModule(PresentersModule())
            .build()
    }

    companion object {
        lateinit var musicComponent: MusicComponent
    }
}