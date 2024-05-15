package com.example.pacesync.presentation.core.models

import java.util.UUID

data class StageModel(val seconds: Int, val id: UUID = UUID.randomUUID())
