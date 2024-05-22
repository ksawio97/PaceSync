package com.example.pacesync.presentation.ui.settings.stages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import com.example.pacesync.R
import com.example.pacesync.presentation.core.models.StageModel

private val maxDigitsInSeconds 
    get() = 3
@Composable
fun EditStageView(
    stage: StageModel,
    onDismissed: () -> Unit,
    onAccepted: (seconds: Int) -> Unit
) {
    var seconds by remember { mutableStateOf(stage.seconds.toString()) }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Box (
            modifier = Modifier
                .fillMaxSize(0.26f)
        ) {
            BasicTextField(
                value = seconds,
                onValueChange = {
                    if (it.length in 1..maxDigitsInSeconds)
                        seconds = it
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxSize()
            )

            StageView(seconds.toInt(),
                Modifier
                    .background(Color.Red)
                    .fillMaxSize())
        }

        Spacer(modifier = Modifier.height(12.dp))
        EditButtons(onDismissed, onAccepted = { onAccepted(seconds.toInt()) })
    }

}

@Composable
fun EditButtons(
    onDismissed: () -> Unit,
    onAccepted: () -> Unit
) {
    Row {
        Button(
            onClick = onDismissed,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White
            ),
            modifier = Modifier.size(34.dp)
        ) {
            Icon (painter= painterResource(R.drawable.baseline_clear_24),
                contentDescription = "Dismiss")
        }
        Spacer(modifier = Modifier.width(12.dp))
        Button(
            onClick = onAccepted,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Green,
                contentColor = Color.White
            ),
            modifier = Modifier.size(34.dp)
        ) {
            Icon (painter= painterResource(R.drawable.baseline_check_24),
                contentDescription = "Dismiss")
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun EditStageViewPreview() {
    Box (
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        EditStageView(StageModel(5), { }, { })
    }
}