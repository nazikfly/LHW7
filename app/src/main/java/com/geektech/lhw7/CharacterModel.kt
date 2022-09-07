package com.geektech.lhw7

import java.io.Serializable

data class CharacterModel(
    var image: Int? = null,
    val name: String,
    val status: String
) : Serializable
