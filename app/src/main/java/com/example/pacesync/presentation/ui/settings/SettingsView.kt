package com.example.pacesync.presentation.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.example.pacesync.R
import com.example.pacesync.presentation.core.managers.StagesManager
import com.example.pacesync.presentation.core.models.StageModel
import com.example.pacesync.presentation.core.viewmodels.SettingsViewModel
import com.example.pacesync.presentation.ui.settings.stages.StagesView
import kotlin.random.Random

@Composable
fun SettingsView(viewModel: SettingsViewModel = hiltViewModel()) {
    val stages by remember { derivedStateOf { viewModel.stages }}
    val showDialog = remember { mutableStateOf(false) }

    LazyColumn (
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Row (verticalAlignment = Alignment.CenterVertically){
                Text(modifier = Modifier.padding(8.dp), text = stringResource(R.string.stages))
                Button (
                    modifier = Modifier
                        .size(16.dp), onClick = { showDialog.value = true }) {
                    Icon(painter = painterResource(R.drawable.baseline_help_24),
                        contentDescription = stringResource(R.string.stages_help))
                }
            }
        }
        item {
            Box (
                modifier = Modifier.heightIn(0.dp, 128.dp)
            ){
                StagesView(
                    stages,
                    modifier = Modifier
                        .padding(8.dp))
            }
        }
        item {
            Button(
                onClick = { viewModel.addStage(StageModel(Random.nextInt(1, 100))) },
                modifier = Modifier
                    .fillMaxWidth(0.6f),
            ) {
                Text(stringResource(R.string.add))
            }
        }

        if (showDialog.value) {
            item {
                StagesInfoDialog {
                    showDialog.value = false
                }
            }
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun Preview() {
    val viewModel = SettingsViewModel(StagesManager())
    repeat(2) {
        viewModel.addStage(StageModel(Random.nextInt(1, 100)))
    }

    SettingsView(viewModel)
}