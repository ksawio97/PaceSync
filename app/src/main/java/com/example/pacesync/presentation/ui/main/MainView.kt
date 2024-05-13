package com.example.pacesync.presentation.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
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
import com.example.pacesync.R
import com.example.pacesync.presentation.theme.PaceSyncTheme


@Composable
fun MainView(navigate: MainNavigate) {
    PaceSyncTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            Row (
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ){
                Button(onClick = { navigate.toSettings() }) {
                    Icon(painter= painterResource(R.drawable.baseline_settings_24),
                        contentDescription = stringResource(R.string.settings_description))
                }
                Button(onClick = { navigate.toStart() }) {
                    Icon(painter= painterResource(R.drawable.baseline_arrow_right_48),
                        contentDescription = stringResource(R.string.settings_description))
                }
            }
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun Preview() {
    MainView(object : MainNavigate {
        override fun toSettings() {}
        override fun toStart() {}
    })
}