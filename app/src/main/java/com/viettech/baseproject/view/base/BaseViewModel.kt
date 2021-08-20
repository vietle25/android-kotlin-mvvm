package com.viettech.baseproject.view.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.viettech.baseproject.utils.Event


/*
 * Class base for view model with loading state, error state
 */
open class BaseViewModel : ViewModel() {

    private val _uiState = MutableLiveData<State>()
    val uiState: LiveData<State> get() = _uiState

    // Emit data observer on UI
    private fun emitUiState(
        isLoading: Boolean = false,
        error: Event<Int>? = null
    ) {
        val dataState = State(isLoading, error)
        _uiState.value = dataState
    }

    // Show loading
    protected fun showLoading(isShow: Boolean) {
        emitUiState(isLoading = isShow)
    }

    // Show error on UI
    protected fun showError(err: Event<Int>) {
        emitUiState(error = err)
    }

    // Common state
    data class State(
        val isLoading: Boolean,
        val error: Event<Int>?
    )
}
