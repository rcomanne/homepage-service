package nl.rcomanne.homepageservice.web

import nl.rcomanne.homepageservice.service.MailSendingService
import nl.rcomanne.homepageservice.web.dto.MailDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/mail")
class MailController(private val mailSendingService: MailSendingService) {

    @GetMapping
    fun sendTestMail() {
        mailSendingService.sendMessage(subject = "Testing Mail", message =  "This is a test mail message")
    }

    @PostMapping
    fun sendMail(@RequestBody request: MailDto) {
        mailSendingService.sendMessage(subject = request.subject, message = request.message, from = request.from)
    }
}