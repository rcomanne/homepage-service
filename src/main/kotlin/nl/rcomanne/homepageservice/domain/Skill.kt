package nl.rcomanne.homepageservice.domain

import javax.persistence.*

@Entity
class Skill(
    @Id @GeneratedValue var id: Long? = null,
    var name: String,
    var progress: Int,
    @Column(length = 512) var description: String,
    @Enumerated(EnumType.STRING) var type: SkillType
)