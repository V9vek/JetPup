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