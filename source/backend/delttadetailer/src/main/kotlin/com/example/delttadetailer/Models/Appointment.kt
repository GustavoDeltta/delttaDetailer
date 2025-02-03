package com.example.delttadetailer.Models

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalTime

@Entity
@Table(name = "appointments")
data class Appointment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "client_name", nullable = false)
    val clientName: String,

    @Column(name = "client_contact", nullable = false)
    val clientContact: String,

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    val service: Service,

    @Column(nullable = false)
    val date: LocalDate,

    @Column(nullable = false)
    val time: LocalTime,

)