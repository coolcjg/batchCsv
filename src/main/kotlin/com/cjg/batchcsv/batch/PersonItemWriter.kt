package com.cjg.batchcsv.batch

import com.cjg.batchcsv.kafka.KafkaProducer
import org.springframework.batch.item.Chunk
import org.springframework.batch.item.ItemWriter
import org.springframework.stereotype.Component

@Component
class PersonItemWriter(
    private var kafkaProducer: KafkaProducer
):ItemWriter<String> {

    override fun write(chunk: Chunk<out String>){
        chunk.forEach{
            kafkaProducer.create("bulk", it)
        }
    }
}