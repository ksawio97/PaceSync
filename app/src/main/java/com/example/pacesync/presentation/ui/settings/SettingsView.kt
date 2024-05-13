package com.example.pacesync.presentation.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.example.pacesync.R

@Composable
fun SettingsView() {
    val showDialog = remember { mutableStateOf(false) }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
            Text(modifier = Modifier.padding(8.dp), text = stringResource(R.string.stages))
            Button (
                modifier = Modifier
                    .size(16.dp), onClick = { showDialog.value = true }) {
                Icon(painter = painterResource(R.drawable.baseline_help_24),
                    contentDescription = stringResource(R.string.stages_help))
            }
        }

        if (showDialog.value) {
            StagesInfoDialog {
                showDialog.value = false
            }
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun Preview() {
    SettingsView()
}