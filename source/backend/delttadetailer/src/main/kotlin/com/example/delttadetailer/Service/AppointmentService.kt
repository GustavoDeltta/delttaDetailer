package com.example.delttadetailer.Service

import com.example.delttadetailer.DTO.AppointmentRequest
import com.example.delttadetailer.Models.Appointment
import com.example.delttadetailer.Repositories.AppointmentRepository
import com.example.delttadetailer.Repositories.ServiceRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalTime

@Service
class AppointmentService(val repository: AppointmentRepository, val serviceRepository: ServiceRepository) {

    fun create(request: AppointmentRequest): Appointment {
        val service = serviceRepository.findById(request.serviceId)
            .orElseThrow { RuntimeException("Serviço não encontrado!") }

        val appointment = Appointment(
            clientName = request.clientName,
            clientContact = request.clientContact,
            service = service,
            date = LocalDate.parse(request.date),
            time = LocalTime.parse(request.time),
        )
        return repository.save(appointment)
    }

}