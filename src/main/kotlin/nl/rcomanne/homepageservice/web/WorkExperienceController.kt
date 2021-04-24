package nl.rcomanne.homepageservice.web

import nl.rcomanne.homepageservice.domain.WorkExperience
import nl.rcomanne.homepageservice.repository.WorkExperienceRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/workexperience")
class WorkExperienceController(private val repository: WorkExperienceRepository) {

    @GetMapping
    fun getWorkExperience(): ResponseEntity<List<WorkExperience>> {
        return ResponseEntity.ok(repository.findAll())
    }
}