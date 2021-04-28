package nl.rcomanne.homepageservice.service

import nl.rcomanne.homepageservice.domain.*
import nl.rcomanne.homepageservice.repository.ApplicationRepository
import nl.rcomanne.homepageservice.repository.EducationRepository
import nl.rcomanne.homepageservice.repository.SkillRepository
import nl.rcomanne.homepageservice.repository.WorkExperienceRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.time.LocalDate
import javax.annotation.PostConstruct

@Component
class DataInitalizer(
    private val applicationRepository: ApplicationRepository,
    private val educationRepository: EducationRepository,
    private val skillRepository: SkillRepository,
    private val workExperienceRepository: WorkExperienceRepository
) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @PostConstruct
    fun generateData() {
        generateApplications()
        generateEducations()
        generateSkills()
        generateWorkExperiences()
    }

    fun generateApplications() {
        if (applicationRepository.findAll().isNotEmpty()) return
        log.debug("generating applications")

        val applications = listOf(
            Application(
                name = "Jenkins",
                description = "My Jenkins CI/CD server",
                link = "https://jenkins.rcomanne.nl",
                imageLink = "https://camo.githubusercontent.com/a5004ae5bffb9a59384514fd88d3f18c47e1e0373bfda94a18b422e4a164d399/68747470733a2f2f6a656e6b696e732e696f2f73697465732f64656661756c742f66696c65732f6a656e6b696e735f6c6f676f2e706e67"
            ),
            Application(
                name = "Traefik",
                description = "Ingress controller for Kubernetes",
                link = "https://traefik.rcomanne.nl",
                imageLink = "https://raw.githubusercontent.com/traefik/traefik/master/docs/content/assets/img/traefik.logo.png"
            ),
            Application(
                name = "Roller Game",
                description = "A simple Unity WebGL browser game",
                link = "https://roller.rcomanne.nl",
                imageLink = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Unity_Technologies_logo.svg/1200px-Unity_Technologies_logo.svg.png"
            ),
            Application(
                name = "Docker registry",
                description = "A private Docker registry for my Kubernetes cluster",
                link = "https://docker.rcomanne.nl",
                imageLink = "https://avatars.githubusercontent.com/u/5429470?s=200&v=4"
            ),
            Application(
                name = "Kibana",
                description = "Monitoring dashboard into the ELK stack, mostly used for metrics / logging",
                link = "https://kibana.rcomanne.nl",
                imageLink = "https://images.contentstack.io/v3/assets/bltefdd0b53724fa2ce/blt5d10f3a91df97d15/5c30744829d13af10bc2abd4/logo-elastic-vertical-reverse.svg"
            )
        )

        log.debug("saving [${applications.size} applications")
        applicationRepository.saveAll(applications)
        log.debug("saved applications")
    }

    fun generateEducations() {
        if (educationRepository.findAll().isNotEmpty()) return
        log.debug("generating educations")

        val educations = listOf(
            Education(
                title = "ICT Bachelor (HBO)",
                school = "Avans Hogeschool, Breda",
                description = """
                    Informatica bachelor of science, done in part time while working for Ordina and Rabobank.
                """.trimIndent(),
                startDate = LocalDate.of(2016, 1, 1),
                endDate = LocalDate.of(2020, 1, 1)
            ),
            Education(
                title = "Archeology Master (WO)",
                school = "University of Amsterdam",
                description = """
                    Started with an Archeology study in Amsterdam, but was not what I expected of it, stopped after a few months.
                """.trimIndent(),
                startDate = LocalDate.of(2014, 1, 1),
                endDate = LocalDate.of(2014, 1, 1)
            ),
            Education(
                title = "Law Master (WO)",
                school = "University of Amsterdam",
                description = """
                    Started with an Law study in Amsterdam, but at the end of the year, I had 40 of the 45 required points to continue.
                """.trimIndent(),
                startDate = LocalDate.of(2012, 1, 1),
                endDate = LocalDate.of(2013, 1, 1)
            ),
            Education(
                title = "VWO E & M",
                school = "Goois Lyceum, Bussum",
                description = """
                    VWO with an Economie and Maatschappij profile at Goois Lyceum in Bussum.
                """.trimIndent(),
                startDate = LocalDate.of(2006, 1, 1),
                endDate = LocalDate.of(2012, 1, 1)
            )
        )

        log.debug("saving [${educations.size}] educations")
        educationRepository.saveAll(educations)
        log.debug("saved educations")
    }

    fun generateSkills() {
        if (skillRepository.findAll().isNotEmpty()) return
        log.debug("generating skills")

        val skills = listOf(
            Skill(
                name = "Java",
                type = SkillType.PROGRAMMING_LANGUAGE,
                progress = 70,
                description = """
                    I have been working with Java for quite a while now and have my OCA certification for Java 8.
                    For more than 3 years I've been active as a Java developer in a large Enterprise, working a lot with Spring Boot and Maven.
                """.trimIndent(),
            ),
            Skill(
                name = "Groovy",
                type = SkillType.PROGRAMMING_LANGUAGE,
                progress = 50,
                description = """
                    I've gained some experience in Groovy due to working with Jenkins and a custom pipeline library for it, as this is all done in Groovy code. 
                    However, I do not have extensive knowledge of the language.
                """.trimIndent()
            ),
            Skill(
                name = "Bash",
                type = SkillType.PROGRAMMING_LANGUAGE,
                progress = 70,
                description = """
                    In creating and automating our infrastructure and CI/CD, I've picked up quite a bit of experience in working with Bash.
                """.trimIndent()
            ),
            Skill(
                name = "Kotlin",
                type = SkillType.PROGRAMMING_LANGUAGE,
                progress = 30,
                description = """
                    While I do have some experience with Kotlin from private projects, this is very limited.
                    I do feel however that it is a language I could pick up quite easily due to my Java experience and the pleasant experience I had with the language when working with it.
                """.trimIndent()
            ),
            Skill(
                name = "JavaScript",
                type = SkillType.PROGRAMMING_LANGUAGE,
                progress = 70,
                description = """
                    I mostly work as a backend developer, but do not shy away from front end work. 
                    I have experience working with React (Native) and AngularJS professionally.
                    However, most of my JavaScript experience comes from private projects, such as this website.
                    I've also used TypeScript for creating simple applications, like building an Azure DevOps custom extension.
                """.trimIndent()
            ),
            Skill(
                name = "GoLang",
                type = SkillType.PROGRAMMING_LANGUAGE,
                progress = 30,
                description = """
                    I have some experience with GoLang, mostly from my study, where we created simple CLI apps, but also a custom web server for file sharing.
                    The language is quite nice to work in, however, I do miss some of the features of Java like a proper class structure.
                """.trimIndent()
            ),
            Skill(
                name = "C#",
                type = SkillType.PROGRAMMING_LANGUAGE,
                progress = 40,
                description = """
                    I got some experience working with C# during my study where we worked a bit with the .NET framework.
                    At the time I was already working with Spring Boot and Java though, and I felt like that was a better development experience, so I do not have any personal projects in it.
                    However, I do have some projects with Unity, which is also written in C#.
                """.trimIndent()
            ),
            Skill(
                name = "Docker",
                type = SkillType.TOOLING,
                progress = 70,
                description = """
                    I've been working with Docker for quite a while now, creating base images, setting up builds for applications etc.
                """.trimIndent()
            ),
            Skill(
                name = "Kubernetes",
                type = SkillType.TOOLING,
                progress = 60,
                description = """
                    We have setup and are running our kubernetes clusters in Azure with AKS, but I've also got my own cluster running on a few VPSes.
                """.trimIndent()
            ),
            Skill(
                name = "Jenkins",
                type = SkillType.CI_CD,
                progress = 90,
                description = """
                    I've gained a lot of experience from working at Rabobank, where we use it extensively.
                    Our team is responsible for pretty much everything Jenkins related, apart from the shared library, which everyone worked on.
                """.trimIndent()
            ),
            Skill(
                name = "Azure DevOps",
                type = SkillType.CI_CD,
                progress = 75,
                description = """
                    I've invested quite a bit of time in setting up our projects and creating templates for teams to use, allowing me to learn a lot of the details of this tool.
                """.trimIndent()
            )
        )

        log.debug("saving [${skills.size}] skills")
        skillRepository.saveAll(skills)
        log.debug("saved skills")
    }

    fun generateWorkExperiences() {
        if (workExperienceRepository.findAll().isNotEmpty()) return
        log.debug("generating work experiences")

        val workExperiences = listOf(
            WorkExperience(
                title = "DevOps Engineer",
                company = "Rabobank",
                description = """
                    As a DevOps Engineer for Rabobank I've been responsible for a lot of different tasks. What started as Java application development, turned into designing, creating and managing infrastructure for the developers.
                    Currently I work a lot on our Azure DevOps CI/CD system, our Kubernetes environment and everything else we have running on Azure.
                """.trimIndent(),
                startDate = LocalDate.of(2018, 5, 1),
                endDate = LocalDate.of(2030, 1, 1)
            ),
            WorkExperience(
                title = "Java Trainee / Software Engineer",
                company = "Ordina",
                description = """
                    Started with a Java Traineeship at Ordina. 
                    After a couple of months of internal training, I was placed at Rabobank to work at the Mortgages department.
                    During this time, I worked on a big monolithic Java application.
                """.trimIndent(),
                startDate = LocalDate.of(2017, 2, 1),
                endDate = LocalDate.of(2018, 5, 1)
            ),
            WorkExperience(
                title = "Project Employee",
                company = "SiSo Computers",
                description = """
                    Worked at SiSo computers on projects where we installed work places at companies while in between studies.
                """.trimIndent(),
                startDate = LocalDate.of(2015, 8, 1),
                endDate = LocalDate.of(2017, 2, 1)
            )
        )

        log.debug("saving [${workExperiences.size}] work experiences")
        workExperienceRepository.saveAll(workExperiences)
        log.debug("saved work experiences")
    }
}