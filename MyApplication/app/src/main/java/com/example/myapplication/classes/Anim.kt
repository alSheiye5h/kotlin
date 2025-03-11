package com.example.myapplication.classes

import com.example.myapplication.R

data class Anim(
    val animation: Int,
    val title: String,
    val description: String,
)


val screens = listOf(
    Anim(R.raw.intro1, "Explore the skies", "discover unbeatable deals on air travel to destinations around the globe"),
    Anim(R.raw.intro2, "Escape to Paradise", "Unwind in breathtaking destinations with exclusive vacation"),
    Anim(R.raw.intro3, "Journey Beyond", "Embark on unforgettable adventures to the world's most iconic landmarks and")
)
