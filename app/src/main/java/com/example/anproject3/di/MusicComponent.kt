package com.example.anproject3.di

import com.example.anproject3.MainActivity
import com.example.anproject3.views.ClassicFrag
import com.example.anproject3.views.PopFrag
import com.example.anproject3.views.RockFrag
import dagger.Component

@Component(
    modules = [
        NetworkModule::class,
        ApplicationModule::class,
        PresentersModule::class
    ]
)
interface MusicComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(classicFrag: ClassicFrag)
    fun inject(popFrag: PopFrag)
    fun inject(rockFrag: RockFrag)
}