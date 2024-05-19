package com.example.pacesync.presentation.core.managers

import com.example.pacesync.presentation.core.models.StageModel
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class StagesManager @Inject constructor() {
    private val _stages = mutableListOf<StageModel>()
    val stages: List<StageModel> get() = _stages

    fun addStage(value: StageModel) {
        _stages.add(value)
    }

    fun removeStage(value: StageModel) {
        _stages.remove(value)
    }
}