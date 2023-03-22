package com.merttoptas.composedeeplinktutorial.feature.screen.settings.navigation

import android.content.Intent
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.merttoptas.composedeeplinktutorial.feature.screen.settings.SettingsScreen

/**
 * Created by mertcantoptas on 22.03.2023
 */

const val settingsNavigationRoute = "settings_route"

fun NavController.navigateSettingsScreen(navOptions: NavOptions? = null) {
    this.navigate(settingsNavigationRoute, navOptions)
}

fun NavGraphBuilder.settingsScreen() {
    composable(
        route = settingsNavigationRoute,
        deepLinks = listOf(navDeepLink {
            uriPattern = "example://compose/settings/{id}"
            action = Intent.ACTION_VIEW
        }),
        arguments = listOf(
            navArgument("id") {
                type = NavType.StringType
                defaultValue = ""
            }
        )
    ) { navBackStackEntry ->
        val argument = navBackStackEntry.arguments?.getString("id")
        SettingsScreen(deepLinkData = argument)
    }
}