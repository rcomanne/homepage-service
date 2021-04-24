package nl.rcomanne.homepageservice.web

import nl.rcomanne.homepageservice.domain.Skill
import nl.rcomanne.homepageservice.repository.SkillRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/skill")
class SkillController(private val repository: SkillRepository) {

    @GetMapping
    fun getSkills(): ResponseEntity<List<Skill>> {
        return ResponseEntity.ok(repository.findAll())
    }
}