package com.dyg.benimkuaforum.screen.commonscreen.model

import com.dyg.benimkuaforum.R


data class ServiceModel(
    val id:String,
    val title: String,
    val assetImage: Int,
    val type: String,
    val duration: String,
    val rating: String,
    val synopsis: String,
    val isPlaying: Boolean
)

val services = listOf(
    ServiceModel(
        id= "4",
        title = "Protez Tırnak",
        assetImage = R.drawable.campaign3,
        type = "Nail",
        duration = "1h 46m",
        rating = "N/A",
        synopsis = "When Superman and the rest of the Justice League are kidnapped, Krypto the Super-Dog must convince a rag-tag shelter pack - Ace the hound, PB the potbellied pig, Merton the turtle and Chip the squirrel - to master their own newfound powers and help him rescue the superheroes.",
        isPlaying = false
    ),
    ServiceModel(
        id= "5",
        title = "Cilt Bakımı",
        assetImage = R.drawable.circular1,
        type = "Skin",
        duration = "2h 11m",
        rating = "N/A",
        synopsis = "Residents in a lonely gulch of inland California bear witness to an uncanny, chilling discovery.",
        isPlaying = false
    ),
    ServiceModel(
        id= "6",
        title = "Lifting",
        assetImage = R.drawable.campaign5,
        type = "Drama",
        duration = "1h 46m",
        rating = "N/A",
        synopsis = "A dramatization of the rescue of a boys soccer team from an underground cave in Thailand.",
        isPlaying = false
    )
)
