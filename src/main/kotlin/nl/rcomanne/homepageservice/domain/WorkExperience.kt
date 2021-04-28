package nl.rcomanne.homepageservice.domain

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class WorkExperience(
    @Id @GeneratedValue var id: Long? = null,
    var title: String,
    var company: String,
    @Column(length = 512) var description: String,
    var startDate: LocalDate,
    var endDate: LocalDate
)