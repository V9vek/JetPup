package com.example.androiddevchallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.androiddevchallenge.ui.navigation.Screen.*
import com.example.androiddevchallenge.ui.screens.DetailsScreen
import com.example.androiddevchallenge.ui.screens.HomeScreen
import com.example.androiddevchallenge.ui.screens.SplashScreen

@Composable
fun JetPupNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Splash.route) {
        composable(route = Splash.route) {
            SplashScreen(
                onSplashComplete = {
                    navController.popBackStack()
                    navController.navigate(Home.route)
                }
            )
        }

        composable(route = Home.route) {
            HomeScreen(
                onPupClick = { pupId ->
                    navController.navigate("${Details.route}/$pupId")
                }
            )
        }

        composable(
            route = "${Details.route}/{pupId}",
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