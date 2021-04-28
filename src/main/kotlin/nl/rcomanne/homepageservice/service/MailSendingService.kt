package nl.rcomanne.homepageservice.service

import org.slf4j.LoggerFactory
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class MailSendingService(private val mailSender: JavaMailSender) {
    private val log = LoggerFactory.getLogger(this.javaClass)

    fun sendMessage(subject: String, message: String, from: String = "ralph@comanne.eu", to: String = "ralph@comanne.eu") {
        log.debug("sending email to [${to}] about [${subject}]")
        val mail = SimpleMailMessage()
        mail.setTo(to)
        mail.setSubject(subject)
        mail.setText("$message\nFrom: $from")

        mailSender.send(mail)
    }
}