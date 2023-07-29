package com.baggio.notification

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(
    scanBasePackages = [
        "com.baggio.notification",
        "com.baggio.amqp",
    ]
)
class NotificationApplication {


//    @Bean
//    fun commandLineRunner(
//        notificationConfig: NotificationConfig,
//        rabbitMQMessageProducer: RabbitMQMessageProducer
//    ): CommandLineRunner {
//        return CommandLineRunner {
//            rabbitMQMessageProducer.publish(
//                NotificationMessage(1, "Hello, welcome to Java Jedi blog"),
//                notificationConfig.internalExchange,
//                notificationConfig.internalCommunicationRoutingKey
//            )
//        }
//    }


}

fun main() {
    SpringApplication.run(NotificationApplication::class.java)
}