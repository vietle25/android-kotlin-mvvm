package com.viettech.baseproject.repository

import com.viettech.baseproject.model.movie.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeRepository {

    @GET("popular")
    suspend fun getPopularMovies(@Query("page") page: Int): MovieResponse
}
