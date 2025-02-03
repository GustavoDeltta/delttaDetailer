package com.example.delttadetailer.Repositories

import com.example.delttadetailer.Models.Service
import org.springframework.data.jpa.repository.JpaRepository

interface ServiceRepository : JpaRepository<Service, Long> {
}