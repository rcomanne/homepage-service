package nl.rcomanne.homepageservice.service

import nl.rcomanne.homepageservice.domain.Education
import nl.rcomanne.homepageservice.domain.Skill
import nl.rcomanne.homepageservice.domain.SkillType
import nl.rcomanne.homepageservice.domain.WorkExperience
import nl.rcomanne.homepageservice.repository.EducationRepository
import nl.rcomanne.homepageservice.repository.SkillRepository
import nl.rcomanne.homepageservice.repository.WorkExperienceRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.time.LocalDate
import javax.annotation.PostConstruct

@Component
class DataInitalizer(
        private val educationRepository: EducationRepository,
        private val skillRepository: SkillRepository,
        private val workExperienceRepository: WorkExperienceRepository
) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @PostConstruct
    fun generateData() {
        generateEducations()
        generateSkills()
        generateWorkExperiences()
    }

    fun generateEducations() {
        if (educationRepository.findAll().isNotEmpty()) return
        log.debug("generating educations")

        val educations = ArrayList<Education>()

        educations.add(Education(
                title = "ICT Bachelor (HBO)",
                school = "Avans Hogeschool, Breda",
                description = """
                    Informatica bachelor of science, done in part time while working for Ordina and Rabobank.
                """.trimIndent(),
                startDate = LocalDate.of(2016, 1, 1),
                endDate = LocalDate.of(2020, 1, 1)
        ))

        educations.add(Education(
                title = "Archeology Master (WO)",
                school = "University of Amsterdam",
                description = """
                    Started with an Archeology study in Amsterdam, but was not what I expected of it, stopped after a few months.
                """.trimIndent(),
                startDate = LocalDate.of(2014, 1, 1),
                endDate = LocalDate.of(2014, 1, 1)
        ))

        educations.add(Education(
                title = "Law Master (WO)",
                school = "University of Amsterdam",
                description = """
                    Started with an Law study in Amsterdam, but at the end of the year, I had 40 of the 45 required points to continue.
                """.trimIndent(),
                startDate = LocalDate.of(2012, 1, 1),
                endDate = LocalDate.of(2013, 1, 1)
        ))

        educations.add(Education(
                title = "VWO E & M",
                school = "Goois Lyceum, Bussum",
                description = """
                    VWO with an Economie and Maatschappij profile at Goois Lyceum in Bussum.
                """.trimIndent(),
                startDate = LocalDate.of(2006, 1, 1),
                endDate = LocalDate.of(2012, 1, 1)
        ))

        log.debug("saving [${educations.size}] educations")
        educationRepository.saveAll(educations)
        log.debug("saved educations")
    }

    fun generateSkills() {
        if (skillRepository.findAll().isNotEmpty()) return
        log.debug("generating skills")

        val skills = ArrayList<Skill>()

        skills.add(Skill(
                name = "Java",
                type = SkillType.PROGRAMMING_LANGUAGE,
                progress = 70,
                description = """
                    I have been working with Java for quite a while now and have my OCA certification for Java 8.
                    For more than 3 years I've been active as a Java developer in a large Enterprise, working a lot with Spring Boot and Maven.
                """.trimIndent(),
        ))

        skills.add(Skill(
                name = "Groovy",
                type = SkillType.PROGRAMMING_LANGUAGE,
                progress = 50,
                description = """
                    I've gained some experience in Groovy due to working with Jenkins and a custom pipeline library for it, as this is all done in Groovy code. 
                    However, I do not have extensive knowledge of the language.
                """.trimIndent()
        ))

        skills.add(Skill(
                name = "Bash",
                type = SkillType.PROGRAMMING_LANGUAGE,
                progress = 70,
                description = """
                    In creating and automating our infrastructure and CI/CD, I've picked up quite a bit of experience in working with Bash.
                """.trimIndent()
        ))

        skills.add(Skill(
                name = "Kotlin",
                type = SkillType.PROGRAMMING_LANGUAGE,
                progress = 30,
                description = """
                    While I do have some experience with Kotlin from private projects, this is very limited.
                    I do feel however that it is a language I could pick up quite easily due to my Java experience and the pleasant experience I had with the language when working with it.
                """.trimIndent()
        ))

        skills.add(Skill(
                name = "JavaScript",
                type = SkillType.PROGRAMMING_LANGUAGE,
                progress = 70,
                description = """
                    I mostly work as a backend developer, but do not shy away from front end work. 
                    I have experience working with React (Native) and AngularJS professionally.
                    However, most of my JavaScript experience comes from private projects, such as this website.
                    I've also used TypeScript for creating simple applications, like building an Azure DevOps custom extension.
                """.trimIndent()
        ))

        skills.add(Skill(
                name = "GoLang",
                type = SkillType.PROGRAMMING_LANGUAGE,
                progress = 30,
                description = """
                    I have some experience with GoLang, mostly from my study, where we created simple CLI apps, but also a custom web server for file sharing.
                    The language is quite nice to work in, however, I do miss some of the features of Java like a proper class structure.
                """.trimIndent()
        ))

        skills.add(Skill(
                name = "C#",
                type = SkillType.PROGRAMMING_LANGUAGE,
                progress = 40,
                description = """
                    I got some experience working with C# during my study where we worked a bit with the .NET framework.
                    At the time I was already working with Spring Boot and Java though, and I felt like that was a better development experience, so I do not have any personal projects in it.
                    However, I do have some projects with Unity, which is also written in C#.
                """.trimIndent()
        ))

        skills.add(Skill(
                name = "Docker",
                type = SkillType.TOOLING,
                progress = 70,
                description = """
                    I've been working with Docker for quite a while now, creating base images, setting up builds for applications etc.
                """.trimIndent()
        ))

        skills.add(Skill(
                name = "Kubernetes",
                type = SkillType.TOOLING,
                progress = 60,
                description = """
                    We have setup and are running our kubernetes clusters in Azure with AKS, but I've also got my own cluster running on a few VPSes.
                """.trimIndent()
        ))

        skills.add(Skill(
                name = "Jenkins",
                type = SkillType.CI_CD,
                progress = 90,
                description = """
                    I've gained a lot of experience from working at Rabobank, where we use it extensively.
                    Our team is responsible for pretty much everything Jenkins related, apart from the shared library, which everyone worked on.
                """.trimIndent()
        ))

        skills.add(Skill(
                name = "Azure DevOps",
                type = SkillType.CI_CD,
                progress = 75,
                description = """
                    I've invested quite a bit of time in setting up our projects and creating templates for teams to use, allowing me to learn a lot of the details of this tool.
                """.trimIndent()
        ))

        log.debug("saving [${skills.size}] skills")
        skillRepository.saveAll(skills)
        log.debug("saved skills")
    }

    fun generateWorkExperiences() {
        if (workExperienceRepository.findAll().isNotEmpty()) return
        log.debug("generating work experiences")

        val workExperiences = ArrayList<WorkExperience>()

        workExperiences.add(WorkExperience(
                title = "DevOps Engineer",
                company = "Rabobank",
                description = """
                    As a DevOps Engineer for Rabobank I've been responsible for a lot of different tasks. What started as Java application development, turned into designing, creating and managing infrastructure for the developers.
                    Currently I work a lot on our Azure DevOps CI/CD system, our Kubernetes environment and everything else we have running on Azure.
                """.trimIndent(),
                startDate = LocalDate.of(2018, 5, 1),
                endDate = LocalDate.of(2030, 1, 1)
        ))

        workExperiences.add(WorkExperience(
                title = "Java Trainee / Software Engineer",
                company = "Ordina",
                description = """
                    Started with a Java Traineeship at Ordina. 
                    After a couple of months of internal training, I was placed at Rabobank to work at the Mortgages department.
                    During this time, I worked on a big monolithic Java application.
                """.trimIndent(),
                startDate = LocalDate.of(2017, 2, 1),
                endDate = LocalDate.of(2018, 5, 1)
        ))

        workExperiences.add(WorkExperience(
                title = "Project Employee",
                company = "SiSo Computers",
                description = """
                    Worked at SiSo computers on projects where we installed work places at companies while in between studies.
                """.trimIndent(),
                startDate = LocalDate.of(2015, 8, 1),
                endDate = LocalDate.of(2017, 2, 1)
        ))

        log.debug("saving [${workExperiences.size}] work experiences")
        workExperienceRepository.saveAll(workExperiences)
        log.debug("saved work experiences")
    }
}