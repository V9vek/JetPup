package com.example.androiddevchallenge.ui.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.ui.graphics.vector.ImageVector

fun getGenderIcon(sex: String): ImageVector {
    return if (sex == "Male") Icons.Default.Male else Icons.Default.Female
}