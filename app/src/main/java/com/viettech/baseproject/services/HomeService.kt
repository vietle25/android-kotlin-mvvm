package com.viettech.baseproject.services

import com.viettech.baseproject.model.movie.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeService {

    @GET("popular")
    suspend fun getPopularMovies(@Query("page") page: Int): MovieResponse
}
