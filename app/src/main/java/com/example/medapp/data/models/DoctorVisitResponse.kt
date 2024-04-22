package com.example.medapp.data.models

data class DoctorVisitResponse(
    val doctor_id: String,
    val patient_id: String,
    val visit_date: String
)