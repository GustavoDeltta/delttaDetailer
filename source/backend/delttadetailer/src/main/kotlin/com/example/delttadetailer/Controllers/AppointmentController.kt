package com.example.delttadetailer.Controllers

import com.example.delttadetailer.DTO.AppointmentRequest
import com.example.delttadetailer.Models.Appointment
import com.example.delttadetailer.Service.AppointmentService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("/appointments")
class AppointmentController(private val appointmentService: AppointmentService) {
    @PostMapping
    fun create(@RequestBody request: AppointmentRequest): Appointment {
        return appointmentService.create(request)
    }
}