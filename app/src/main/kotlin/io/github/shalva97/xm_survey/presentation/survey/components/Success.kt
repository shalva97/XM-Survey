package io.github.shalva97.xm_survey.presentation.survey.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SuccessState() {
    Text(
        text = "Success",
        modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .padding(16.dp),
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.titleLarge
    )
}

@Preview
@Composable
private fun Preview() {
    SuccessState()
}
