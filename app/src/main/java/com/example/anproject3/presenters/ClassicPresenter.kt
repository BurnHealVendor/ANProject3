package com.example.anproject3.presenters

import android.content.Context
import com.example.anproject3.model.SongItem
import com.example.anproject3.rest.MusicRepo
import com.example.anproject3.rest.NetworkUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ClassicPresenterImpl @Inject constructor(
    private var context: Context?,
    private val disposables: CompositeDisposable,
    private val networkUtils: NetworkUtils,
    private val musicRepo: MusicRepo,
    private var classicViewContract: ClassicViewContract? = null
) : ClassicPresenterContract {

    override fun initializePres(viewContract: ClassicViewContract) {
        classicViewContract = viewContract
    }

    override fun checkNetworkConn() {
        networkUtils.registerForNetworkState()
    }

    override fun getClassic() {
        classicViewContract?.loadingClassic(true)

        musicRepo.getSongsByGenre("classic")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { music -> classicViewContract?.classicSuccess(music.classic) },
                { error -> classicViewContract?.classicError(error) }
            )
            .apply {
                disposables.add(this)
            }
    }

    override fun destroyPres() {
        context = null
        networkUtils.unregisterFromNetworkState()
        classicViewContract = null
        disposables.clear()
    }
}

interface ClassicPresenterContract {
    fun initializePres(viewContract: ClassicViewContract)
    fun checkNetworkConn()
    fun getClassic()
    fun destroyPres()
}

interface ClassicViewContract {
    fun loadingClassic(isLoading: Boolean)
    fun classicSuccess(music: List<SongItem>)
    fun classicError(error: Throwable)
}