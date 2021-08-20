package com.viettech.baseproject.model.movie

import com.google.gson.annotations.SerializedName

data class MovieModel(

    @SerializedName("adult")
    var adult: Boolean? = null,

    @SerializedName("backdrop_path")
    var backdropPath: String? = null,

    @SerializedName("id")
    var id: Int,

    @SerializedName("original_language")
    var originalLanguage: String? = null,

    @SerializedName("original_title")
    var originalTitle: String? = null,

    @SerializedName("overview")
    var overview: String? = null,

    @SerializedName("poster_path")
    var posterPath: String? = null
)