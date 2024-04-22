package com.example.medapp.data.models

data class ResponseBody<T>(
    val status:String,
    val time:String,
    val message:String,
    val data:T
)
