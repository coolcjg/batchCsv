package com.cjg.batchcsv.batch

import org.springframework.batch.item.kafka.KafkaItemWriter
import org.springframework.batch.item.kafka.builder.KafkaItemWriterBuilder
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class PersonKafkaItemWriter(
    val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun getKafkaItemWriter() : KafkaItemWriter<String, String> {
        return KafkaItemWriterBuilder<String,String>()
            .kafkaTemplate(kafkaTemplate)
            .build()
    }
}