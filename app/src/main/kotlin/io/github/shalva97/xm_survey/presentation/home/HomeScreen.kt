package io.github.shalva97.xm_survey.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import io.github.shalva97.xm_survey.R
import io.github.shalva97.xm_survey.presentation.SURVEY

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(modifier = Modifier.padding(top = 8.dp), text = stringResource(R.string.welcome))
        Spacer(modifier = Modifier.fillMaxHeight(.3f))
        Button(modifier = Modifier.fillMaxWidth(.5f), onClick = {
            navController.navigate(SURVEY)
        }) {
            Text(text = stringResource(R.string.start_survey))
        }
    }
}
