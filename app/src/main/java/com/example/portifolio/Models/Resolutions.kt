package com.example.androidflow.Models

import com.example.portifolio.Models.Medium
import com.google.gson.annotations.SerializedName

data class Resolutions (

    @SerializedName("original") var original : Original,
    @SerializedName("medium") var medium : Medium

)