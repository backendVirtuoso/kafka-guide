package com.example.kafkaguide

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.annotation.EnableKafkaStreams

@SpringBootApplication
@EnableKafka
@EnableKafkaStreams
class KafkaGuideApplication

fun main(args: Array<String>) {
    runApplication<KafkaGuideApplication>(*args)
}
