package com.merttoptas.composedeeplinktutorial

import android.content.Intent
import android.net.Uri
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by mertcantoptas on 22.03.2023
 */
@RunWith(AndroidJUnit4::class)
class AppDeepLinkingTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = activityScenarioRule.scenario
    }

    @After
    fun cleanup() {
        scenario.close()
    }

    @Test
    fun deepLinkApplicationTextSettingsDeeplinkHasText() {
        // Launch the activity with the deep link
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("example://compose/settings/foo")
        }
        scenario.onActivity { activity ->
            activity.startActivity(intent)
        }

        // Verify that the activity displays the expected text
        val value = composeTestRule.onNodeWithTag("deeplinkArgument")
        value.assertTextEquals("foo")
        for ((key, value) in value.fetchSemanticsNode().config) {
            if (key.name == "EditableText") {
                assertEquals("foo", value.toString())
            }
        }
    }

    @Test
    fun deepLinkApplicationTextDashboardDeeplinkHasText() {
        // Launch the activity with the deep link
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("example://compose/dashboard/johnDoe")
        }
        scenario.onActivity { activity ->
            activity.startActivity(intent)
        }

        // Verify that the activity displays the expected text
        val value = composeTestRule.onNodeWithTag("dashboardDeeplinkArgument")
        value.assertTextEquals("This is Home Screen johnDoe")
        for ((key, value) in value.fetchSemanticsNode().config) {
            if (key.name == "EditableText") {
                assertEquals("This is Home Screen johnDoe", value.toString())
            }
        }
    }
}