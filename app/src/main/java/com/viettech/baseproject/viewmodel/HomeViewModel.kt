package com.viettech.baseproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.viettech.baseproject.model.movie.MovieModel
import com.viettech.baseproject.repository.HomeRepository
import com.viettech.baseproject.utils.Event
import com.viettech.baseproject.view.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val homeRepository: HomeRepository) : BaseViewModel() {

    val movies = MutableLiveData<Event<List<MovieModel>?>>()

    // Call when model create
    init {
        retrieveMovies()
    }

    // Call API
    private fun retrieveMovies() {
        viewModelScope.launch {
            runCatching {
                showLoading(true)
                homeRepository.getPopularMovies(1)
            }.onSuccess {
                showLoading(false)
                movies.value = Event(it.results)
            }.onFailure {
                it.printStackTrace()
            }
        }
    }
}