package com.example.medapp.view.visits

import androidx.lifecycle.ViewModel
import com.example.medapp.data.repository.VisitsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VisitsViewModel @Inject constructor(private val visitsRepository: VisitsRepository) :
    ViewModel() {
}