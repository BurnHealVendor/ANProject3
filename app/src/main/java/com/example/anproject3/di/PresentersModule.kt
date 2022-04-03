package com.example.anproject3.di

import android.content.Context
import com.example.anproject3.presenters.ClassicPresenterContract
import com.example.anproject3.presenters.ClassicPresenterImpl
import com.example.anproject3.presenters.ClassicViewContract
import com.example.anproject3.rest.MusicRepo
import com.example.anproject3.rest.NetworkUtils
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class PresentersModule {
    @Provides
    fun provideCompDisposable() = CompositeDisposable()

    @Provides
    fun providesClassicPresenter(
        context: Context?,
        disposables: CompositeDisposable,
        networkUtils: NetworkUtils,
        musicRepo: MusicRepo
    ): ClassicPresenterContract {
        return ClassicPresenterImpl(context, disposables, networkUtils, musicRepo)
    }
}