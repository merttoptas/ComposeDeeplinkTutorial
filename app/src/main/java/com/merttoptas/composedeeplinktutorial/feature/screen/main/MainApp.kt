@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)

package com.merttoptas.composedeeplinktutorial.feature.screen.main

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.compose.rememberNavController
import com.merttoptas.composedeeplinktutorial.feature.navigation.MainNavHost
import com.merttoptas.composedeeplinktutorial.ui.components.MainAppScaffold

/**
 * Created by mertcantoptas on 19.03.2023
 */


@Composable
fun MainApp(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    MainAppScaffold(
        modifier = modifier.semantics {
            testTagsAsResourceId = true
        },
        backgroundColor = MaterialTheme.colorScheme.background,
    ) {
        MainNavHost(
            navController = navController
        )
    }
}