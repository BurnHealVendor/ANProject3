package com.example.anproject3.rest

import com.example.anproject3.model.Songs
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicAPI {
    @GET("search")
    fun getSongs(
        @Query("term") term: String,
        @Query("amp;media") media: String = "music",
        @Query("amp;entity") entity: String = "song",
        @Query("limit") limit: Int = 50,
    ): Single<Songs>

    companion object {
        const val BASE_URL = "https://itunes.apple.com/"
    }
}
