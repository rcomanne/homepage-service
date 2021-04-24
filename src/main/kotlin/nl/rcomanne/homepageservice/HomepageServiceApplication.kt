package nl.rcomanne.homepageservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HomepageServiceApplication

fun main(args: Array<String>) {
    runApplication<HomepageServiceApplication>(*args)
}
