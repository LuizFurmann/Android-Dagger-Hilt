package com.example.androidflow.Models

import com.google.gson.annotations.SerializedName

data class Original(

    @SerializedName("url") var url: String,
    @SerializedName("width") var width: Int,
    @SerializedName("height") var height: Int

)