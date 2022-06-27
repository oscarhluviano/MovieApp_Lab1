package com.example.movieapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), MovieAdapter.OnItemListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieAdapter = MovieAdapter(this) // (2)
        binding.rvMovies.adapter = movieAdapter// (3)
        print(movieAdapter.movies.size)
        movieAdapter.movies = Movie.data // (4)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun clickMovie(movie: Movie) {
        Toast.makeText(this.context, movie.title, Toast.LENGTH_SHORT).show()

        val bundle = Bundle()
        bundle.putString("titulo", movie.title)
        bundle.putString("description", movie.description)
        bundle.putInt("video", movie.video)
        bundle.putInt("img", movie.featuredImage)
        parentFragmentManager.setFragmentResult("datosf1",bundle)

        findNavController().navigate(R.id.action_nav_home_to_detailsFragment2)
    }
}