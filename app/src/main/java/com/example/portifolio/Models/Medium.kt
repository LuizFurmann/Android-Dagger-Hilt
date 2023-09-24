package com.example.portifolio.Models

import com.google.gson.annotations.SerializedName


data class Medium(

    @SerializedName("url") var url: String,
    @SerializedName("width") var width: Int,
    @SerializedName("height") var height: Int

)