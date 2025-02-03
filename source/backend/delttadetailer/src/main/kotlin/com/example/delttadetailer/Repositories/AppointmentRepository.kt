package com.example.delttadetailer.Repositories

import com.example.delttadetailer.Models.Appointment
import org.springframework.data.jpa.repository.JpaRepository

interface AppointmentRepository : JpaRepository<Appointment, Long> {
}