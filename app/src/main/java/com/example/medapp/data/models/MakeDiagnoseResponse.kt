package com.example.medapp.data.models

data class MakeDiagnoseResponse(
    val diagnosis: String,
    val diagnosis_date: String,
    val id: Int,
    val patient_id: String,
    val recovery_date: Any
)