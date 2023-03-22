package com.merttoptas.composedeeplinktutorial.feature.screen.home.navigation

import android.content.Intent
import android.util.Log
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.merttoptas.composedeeplinktutorial.feature.screen.home.HomeScreenRoute

/**
 * Created by mertcantoptas on 19.03.2023
 */
const val homeNavigationRoute = "home_route"

fun NavController.navigateHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(homeNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeScreen() {
    composable(
        route = homeNavigationRoute,
        deepLinks = listOf(navDeepLink {
            uriPattern = "example://compose/dashboard/{name}"
            action = Intent.ACTION_VIEW
        }),
        arguments = listOf(
            navArgument("name") {
                type = NavType.StringType
                defaultValue = ""
            }
        )
    ) { navBackStackEntry ->
        val argument = navBackStackEntry.arguments?.getString("name")
        HomeScreenRoute(deepLinkData = argument)
    }
}

