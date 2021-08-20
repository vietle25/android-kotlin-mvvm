package com.viettech.baseproject.view.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.viettech.baseproject.R
import com.viettech.baseproject.databinding.FragmentHomeBinding
import com.viettech.baseproject.enum.MovieType
import com.viettech.baseproject.view.base.BaseFragment
import com.viettech.baseproject.viewmodel.HomeViewModel
import com.viettech.baseproject.widget.ItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val movieViewModel: HomeViewModel by viewModel()

    @SuppressLint("ShowToast")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupMovieList()
        val type = "Action"

        if ( MovieType.valueOf(type) == MovieType.Action) {
            Toast.makeText(context, "YESSSSSSSSSS,", Toast.LENGTH_LONG).show()
        }
    }

    private fun setupMovieList() {
        val adapter = MovieAdapter()
        binding.recyclerView.adapter = adapter
        val divider =
            ContextCompat.getDrawable(context ?: return, R.drawable.shape_movie_divider) ?: return
        val horizontalSpacing = resources.getDimensionPixelOffset(R.dimen.dp_16)
        val itemDecoration = ItemDecoration(horizontalSpacing, divider)
        binding.recyclerView.addItemDecoration(itemDecoration)

        movieViewModel.uiState.observe(viewLifecycleOwner, Observer {
            val dataState = it ?: return@Observer
            binding.progress.visibility = if (dataState.isLoading) View.VISIBLE else View.GONE
            if (dataState.error != null && !dataState.error.consumed)
                dataState.error.consume()?.let { errorResource ->
                    // handle error state
                }
        })
        movieViewModel.movies.observe(viewLifecycleOwner, Observer {
            val dataState = it ?: return@Observer

            if (!dataState.consumed)
                dataState.consume()?.let { movies ->
                    println(movies)
                    adapter.submitList(movies)
                }
        })
    }

}