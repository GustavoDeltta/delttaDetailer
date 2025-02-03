package com.example.delttadetailer.Models

import jakarta.persistence.*

@Entity
@Table(name = "services")
data class Service(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val description: String?,
    val price: Double,
    val imglink: String
)
