/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
