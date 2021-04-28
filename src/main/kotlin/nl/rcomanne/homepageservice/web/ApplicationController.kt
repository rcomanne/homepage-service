package nl.rcomanne.homepageservice.web

import nl.rcomanne.homepageservice.domain.Application
import nl.rcomanne.homepageservice.repository.ApplicationRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/application")
class ApplicationController(
    private val applicationRepository: ApplicationRepository
) {

    @GetMapping
    fun getApplications(): ResponseEntity<List<Application>> {
        return ResponseEntity.ok(applicationRepository.findAll())
    }
}