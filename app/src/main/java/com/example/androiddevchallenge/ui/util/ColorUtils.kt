package com.example.androiddevchallenge.ui.util

import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.ui.theme.blue
import com.example.androiddevchallenge.ui.theme.female
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.male
import com.example.androiddevchallenge.ui.theme.orange
import com.example.androiddevchallenge.ui.theme.red

fun getBackgroundColor(): Color {
    val colorsList = listOf(red, green, blue, orange)
    return colorsList.random()
}

fun getGenderColor(sex: String): Color {
    return if (sex == "Male") male else female
}