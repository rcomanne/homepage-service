package nl.rcomanne.homepageservice.service

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class MailSendingService(private val mailSender: JavaMailSender) {
    fun sendMessage(to: String, subject: String, message: String) {
        val mail = SimpleMailMessage()
        mail.setTo(to)
        mail.setSubject(subject)
        mail.setText(message)

        mailSender.send(mail)
    }
}