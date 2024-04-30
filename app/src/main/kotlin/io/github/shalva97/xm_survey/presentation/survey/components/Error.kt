package io.github.shalva97.xm_survey.presentation.survey.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.shalva97.xm_survey.R
import io.github.shalva97.xm_survey.presentation.theme.ErrorBackground

@Composable
fun ErrorState(onRetryClick: () -> Unit) {
    Row(
        Modifier
            .background(ErrorBackground)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.failure),
            modifier = Modifier.padding(start = 16.dp),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge
        )
        Button(modifier = Modifier.padding(end = 16.dp), onClick = onRetryClick) {
            Text(text = stringResource(R.string.retry))
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ErrorState { /*TODO*/ }
}
