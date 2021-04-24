package nl.rcomanne.homepageservice.domain

import java.time.LocalDate
import javax.persistence.*

@Entity
class Education (
        @Id @GeneratedValue var id: Long? = null,
        var title: String,
        var school: String,
        @Column(length = 512) var description: String,
        var startDate: LocalDate,
        var endDate: LocalDate
)

@Entity
class Skill(
        @Id @GeneratedValue var id: Long? = null,
        var name: String,
        var progress: Int,
        @Column(length = 512) var description: String,
        @Enumerated(EnumType.STRING) var type: SkillType
)

enum class SkillType {
    PROGRAMMING_LANGUAGE,
    TOOLING,
    CI_CD,
}

@Entity
class WorkExperience(
        @Id @GeneratedValue var id: Long? = null,
        var title: String,
        var company: String,
        @Column(length = 512) var description: String,
        var startDate: LocalDate,
        var endDate: LocalDate
)