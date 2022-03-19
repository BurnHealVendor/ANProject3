package com.example.anproject3.model

import com.google.gson.annotations.SerializedName

data class PopMusic(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val pop: List<Pop>
)