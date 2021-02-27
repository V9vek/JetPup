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
package com.example.androiddevchallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.screens.DetailsScreen
import com.example.androiddevchallenge.ui.screens.HomeScreen
import com.example.androiddevchallenge.ui.screens.SplashScreen

@Composable
fun JetPupNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen(
                onSplashComplete = {
                    navController.popBackStack()
                    navController.navigate(Screen.Home.route)
                }
            )
        }

        composable(route = Screen.Home.route) {
            HomeScreen(
                onPupClick = { pupId ->
                    navController.navigate("${Screen.Details.route}/$pupId")
                }
            )
        }

        composable(
            route = "${Screen.Details.route}/{pupId}",
            arguments = listOf(navArgument("pupId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getInt("pupId")?.let { pupId ->
                DetailsScreen(
                    pupId = pupId,
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}
