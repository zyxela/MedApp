package com.example.medapp.data.models

data class MakeVisitResponse(
    val doctor_id: String,
    val id: Int,
    val patient_id: Int,
    val visit_date: String
)