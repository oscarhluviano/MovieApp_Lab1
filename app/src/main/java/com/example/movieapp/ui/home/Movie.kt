package com.example.movieapp.ui.home

import com.example.movieapp.R

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val featuredImage: Int
){
    companion object {
        val data
            get() = listOf(
                Movie(
                    1,
                    "Sword Art Online",
                    "Anime",
                    R.drawable.sao
                ),
                Movie(
                    2,
                    "Naruto The Last",
                    "Anime",
                    R.drawable.naruto
                ),
                Movie(
                    3,
                    "WeCrashed",
                    "Serie",
                    R.drawable.wecrashed
                ),
                Movie(
                    4,
                    "Shrek",
                    "Animada",
                    R.drawable.shrek
                ),
                Movie(
                    5,
                    "Your name",
                    "Anime",
                    R.drawable.yourname
                )
            )
    }
}

