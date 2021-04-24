package nl.rcomanne.homepageservice.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "mail-sender")
class MailSenderProperties(
        val host: String,
        val port: Int,
        val username: String,
        val password: String,
        val auth: Boolean,
        val starttlsEnable: Boolean
)