package com.example.anproject3.model

import com.google.gson.annotations.SerializedName

data class Songs(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val classic: List<SongItem>
)