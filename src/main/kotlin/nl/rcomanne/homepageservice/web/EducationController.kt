package nl.rcomanne.homepageservice.web

import nl.rcomanne.homepageservice.domain.Education
import nl.rcomanne.homepageservice.repository.EducationRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/education")
class EducationController(private val repository: EducationRepository) {

    @GetMapping
    fun getEducations(): ResponseEntity<List<Education>> {
        return ResponseEntity.ok(repository.findAll())
    }
}