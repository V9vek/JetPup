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
package com.example.androiddevchallenge.ui.screens

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import kotlinx.coroutines.delay

// Taken from android/compose-samples/Crane and modified

private const val SplashWaitTime: Long = 1000

@Composable
fun SplashScreen(
    onSplashComplete: () -> Unit
) {
    val transitionState = remember { MutableTransitionState(SplashState.SHOWN) }
    val transition = updateTransition(transitionState = transitionState)
    val splashAlpha by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 100) }
    ) {
        if (it == SplashState.SHOWN) 1f else 0f
    }

    Splash(
        modifier = Modifier.alpha(splashAlpha),
        onTimeout = { transitionState.targetState = SplashState.COMPLETED },
        onSplashComplete = onSplashComplete
    )
}

@Composable
private fun Splash(
    modifier: Modifier,
    onTimeout: () -> Unit,
    onSplashComplete: () -> Unit
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        val currentOnTimeout by rememberUpdatedState(newValue = onTimeout)

        LaunchedEffect(Unit) {
            delay(SplashWaitTime)
            currentOnTimeout()
            onSplashComplete()
        }
        Image(
            painter = painterResource(id = R.drawable.husky_art),
            contentDescription = "Splash",
            modifier = Modifier.size(100.dp, 120.dp)
        )
    }
}

enum class SplashState { SHOWN, COMPLETED }
