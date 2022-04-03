package com.example.anproject3.rest

import com.example.anproject3.model.Songs
import io.reactivex.Single
import javax.inject.Inject

interface MusicRepo {
    fun getSongsByGenre(genre: String): Single<Songs>
}

class MusicRepoImpl @Inject constructor(
    private val musicAPI: MusicAPI
) : MusicRepo {

    override fun getSongsByGenre(genre: String): Single<Songs> {
        return musicAPI.getSongs(genre)
    }
}