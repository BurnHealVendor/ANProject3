package com.example.anproject3.rest

import com.example.anproject3.model.Classic
import com.example.anproject3.model.ClassicMusic
import io.reactivex.Single
import javax.inject.Inject

interface MusicRepo {
    fun getClassic(): Single<ClassicMusic>
}

class MusicRepoImpl @Inject constructor(
    private val musicAPI: MusicAPI
) : MusicRepo {

    override fun getClassic(): Single<ClassicMusic> {
        return musicAPI.getClassicMusic()
    }
}