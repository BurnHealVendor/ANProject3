package com.example.anproject3.model

import com.google.gson.annotations.SerializedName

data class RockMusic(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val rock: List<Rock>
)