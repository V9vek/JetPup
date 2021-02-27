package com.example.androiddevchallenge.ui.screens

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
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
    Box(modifier = modifier.fillMaxSize(),  contentAlignment = Alignment.Center) {
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