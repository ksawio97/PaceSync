package com.example.pacesync.presentation.core.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.pacesync.presentation.core.managers.StagesManager
import com.example.pacesync.presentation.core.models.StageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val stagesManager: StagesManager
) : ViewModel() {
    private val _stages = mutableStateListOf<StageModel>()
    val stages: List<StageModel> get() = _stages
    
    init {
        _stages.addAll(stagesManager.stages)
    }

    fun addStage(stage: StageModel) {
        stagesManager.addStage(stage)
        _stages.add(stage)
    }

    fun removeStage(stage: StageModel) {
        stagesManager.removeStage(stage)
        _stages.remove(stage)
    }
}