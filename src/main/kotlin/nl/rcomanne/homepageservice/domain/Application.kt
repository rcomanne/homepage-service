package nl.rcomanne.homepageservice.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Application(
    @Id @GeneratedValue var id: Long? = null,
    var name: String,
    @Column(length = 512) var description: String,
    var link: String,
    var imageLink: String,
)