package io.github.shalva97.xm_survey

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import io.github.shalva97.xm_survey.presentation.MainActivity
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun whenAppOpensThenWelcomeScreenIsDisplayed() {
        composeTestRule.onNodeWithText("Welcome").assertIsDisplayed()
    }

    @Test
    fun whenUserClicksStartSurveyThenSurveyScreenIsShown() {
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.start_survey))
            .performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.question_20, 1))
            .assertIsDisplayed()
    }
}
