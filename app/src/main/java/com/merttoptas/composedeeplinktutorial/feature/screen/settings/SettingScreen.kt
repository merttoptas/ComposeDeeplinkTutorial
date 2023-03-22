package com.merttoptas.composedeeplinktutorial.feature.screen.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag

/**
 * Created by mertcantoptas on 22.03.2023
 */

@Composable
internal fun SettingsScreenRoute(
    modifier: Modifier = Modifier,
    deepLinkData: String? = null
) {
    SettingsScreen(modifier, deepLinkData)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    deepLinkData: String? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(text = "Settings Screen")
                },
            )
        },
        content = { paddingValues ->
            Content(modifier = Modifier.padding(paddingValues), deepLinkData)
        }
    )
}

@Composable
fun Content(modifier: Modifier = Modifier, deepLinkData: String? = null) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "This is Settings Screen",
            modifier = Modifier.testTag("title"),
            color = Color.Blue
        )
        Text(
            text = "$deepLinkData",
            modifier = Modifier.testTag("deeplinkArgument"),
            color = Color.Blue
        )

    }
}