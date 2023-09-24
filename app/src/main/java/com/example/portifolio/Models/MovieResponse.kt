package com.example.androidflow.Models

import com.google.gson.annotations.SerializedName

data class MovieResponse (
    @SerializedName("id") var id : Int,
    @SerializedName("type") var type : String,
    @SerializedName("main") var main : Boolean,
    @SerializedName("resolutions") var resolutions : Resolutions
)