package nl.rcomanne.homepageservice.web

import nl.rcomanne.homepageservice.service.MailSendingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mail")
class MailController(private val mailSendingService: MailSendingService) {

    @GetMapping
    fun sendTestMail() {
        mailSendingService.sendMessage("ralph@comanne.eu", "Testing Mail", "This is a test mail message")
    }
}