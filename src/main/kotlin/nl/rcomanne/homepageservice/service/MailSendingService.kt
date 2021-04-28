package nl.rcomanne.homepageservice.service

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class MailSendingService(private val mailSender: JavaMailSender) {
    fun sendMessage(subject: String, message: String, from: String = "ralph@comanne.eu", to: String = "ralph@comanne.eu") {
        val mail = SimpleMailMessage()
        mail.setTo(to)
        mail.setSubject(subject)
        mail.setText("$message\nFrom: $from")

        mailSender.send(mail)
    }
}