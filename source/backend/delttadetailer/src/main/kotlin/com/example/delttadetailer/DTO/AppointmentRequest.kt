package com.example.delttadetailer.DTO

data class AppointmentRequest(
    val clientName: String,
    val clientContact: String,
    val serviceId: Long,
    val date: String,
    val time: String
)
