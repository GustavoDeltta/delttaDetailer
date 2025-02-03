package com.example.delttadetailer.Controllers

import com.example.delttadetailer.Models.Service
import com.example.delttadetailer.Repositories.ServiceRepository
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/services")
class ServiceController(val repository: ServiceRepository) {
    @GetMapping
    fun getAll(): List<Service> = repository.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Service? = repository.findById(id).orElse(null)
}