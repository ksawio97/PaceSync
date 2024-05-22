package com.example.pacesync.presentation.ui.settings.stages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text

@Composable
fun StageView(seconds: Int, modifier: Modifier = Modifier) {
    Box (
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(8.dp)
    ) {
        Text("$seconds", fontSize = MaterialTheme.typography.body2.fontSize)
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun StageViewPreview() {
    Box (
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        StageView(2, Modifier.background(Color.Blue).size(32.dp))
    }
}