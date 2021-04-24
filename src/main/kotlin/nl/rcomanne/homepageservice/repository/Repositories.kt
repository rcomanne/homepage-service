package nl.rcomanne.homepageservice.repository

import nl.rcomanne.homepageservice.domain.Education
import nl.rcomanne.homepageservice.domain.Skill
import nl.rcomanne.homepageservice.domain.WorkExperience
import org.springframework.data.jpa.repository.JpaRepository

interface EducationRepository : JpaRepository<Education, Long> {

}

interface SkillRepository : JpaRepository<Skill, Long> {

}

interface WorkExperienceRepository : JpaRepository<WorkExperience, Long> {

}