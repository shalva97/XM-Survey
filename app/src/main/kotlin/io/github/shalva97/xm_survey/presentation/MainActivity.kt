package io.github.shalva97.xm_survey.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.shalva97.xm_survey.presentation.home.HomeScreen
import io.github.shalva97.xm_survey.presentation.survey.SurveyScreen
import io.github.shalva97.xm_survey.presentation.theme.XMSurveyTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            XMSurveyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // TODO set HOME as start destination
                    NavHost(navController = navController, startDestination = SURVEY) {
                        composable(HOME) { HomeScreen(navController) }
                        composable(SURVEY) { SurveyScreen() }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    XMSurveyTheme {
        Greeting("Android")
    }
}

const val HOME = "home"
const val SURVEY = "survey"
