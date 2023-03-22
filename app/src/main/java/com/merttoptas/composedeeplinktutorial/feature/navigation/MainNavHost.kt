package com.merttoptas.composedeeplinktutorial.feature.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.merttoptas.composedeeplinktutorial.feature.screen.home.navigation.homeNavigationRoute
import com.merttoptas.composedeeplinktutorial.feature.screen.home.navigation.homeScreen
import com.merttoptas.composedeeplinktutorial.feature.screen.settings.navigation.settingsScreen

/**
 * Created by mertcantoptas on 19.03.2023
 */

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = homeNavigationRoute
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        homeScreen()
        settingsScreen()
    }
}