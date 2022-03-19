package com.example.anproject3.rest

import com.example.anproject3.model.Classic
import com.example.anproject3.model.ClassicMusic
import com.example.anproject3.model.Pop
import com.example.anproject3.model.Rock
import io.reactivex.Single
import retrofit2.http.GET

interface MusicAPI {
    @GET("search?term=classick&amp;media=music&amp;entity=song&amp;limit=50")
    fun getClassicMusic(): Single<ClassicMusic>

    @GET("search?term=pop&amp;media=music&amp;entity=song&amp;limit=50")
    fun getPopMusic(): Single<Pop>

    @GET("search?term=rock&amp;media=music&amp;entity=song&amp;limit=50")
    fun getRockMusic(): Single<Rock>

    companion object {
        const val BASE_URL = "https://itunes.apple.com/"
    }
}
