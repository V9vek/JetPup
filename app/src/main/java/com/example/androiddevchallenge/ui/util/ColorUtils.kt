package com.example.androiddevchallenge.ui.util

import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.ui.theme.*

fun getBackgroundColor(): Color {
    val colorsList = listOf(red, green, blue, orange)
    return colorsList.random()
}

fun getGenderColor(sex: String): Color {
    return if (sex == "Male") male else female
}