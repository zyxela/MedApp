package com.example.medapp.data.models

data class HistoryResponse(
    val diagnosis: String,
    val diagnosis_date: String,
    val patient_id: String,
    val recovery_date: String
)