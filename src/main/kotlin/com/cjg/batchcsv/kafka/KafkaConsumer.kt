package com.cjg.batchcsv.kafka

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component


@Component
class KafkaConsumer {

    @KafkaListener(topics = ["bulk"])
    fun listener(@Payload data:String){
        println("sub : $data")
    }
}