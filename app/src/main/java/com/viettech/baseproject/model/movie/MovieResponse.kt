package com.viettech.baseproject.model.movie

import com.google.gson.annotations.SerializedName


data class MovieResponse(

    @SerializedName("page")
    val page: Int? = null,

    @SerializedName("results")
    val results: List<MovieModel>? = null,

    @SerializedName("total_pages")
    val totalPage: Int? = null,

    @SerializedName("total_results")
    val totalResult: Int? = null
)