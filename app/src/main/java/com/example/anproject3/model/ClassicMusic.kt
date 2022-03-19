package com.example.anproject3.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class ClassicMusic(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val classic: List<Classic>
)