package com.cjg.batchcsv.batch.config

import com.cjg.batchcsv.batch.PersonItemProcessor
import com.cjg.batchcsv.batch.PersonItemWriter
import com.cjg.batchcsv.batch.PersonKafkaItemWriter
import com.cjg.batchcsv.dto.Person
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer
import org.springframework.batch.item.kafka.KafkaItemWriter
import org.springframework.batch.item.kafka.builder.KafkaItemWriterBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class BatchConfig(
    val personItemProcessor: PersonItemProcessor
    , val personItemWriter : PersonItemWriter
) {

    private val chunkSize = 1000

    @Bean
    fun reader():FlatFileItemReader<Person>{
        return FlatFileItemReaderBuilder<Person>()
            .name("personItemReader")
            .resource(FileSystemResource("C:/Users/cjg/Downloads/test.csv"))
            .lineTokenizer(DelimitedLineTokenizer())
            .linesToSkip(1)
            .fieldSetMapper(PersonFieldSetMapper())
            .build()
    }

    @Bean
    @JobScope
    fun step(jobRepository:JobRepository
             , transactionManager: PlatformTransactionManager
    ):Step{
        return StepBuilder("Step", jobRepository)
            .chunk<Person, String>(3, transactionManager)
            .reader(reader())
            .processor(personItemProcessor)
            .writer(personItemWriter)
            .build()
    }

    @Bean
    fun job(jopRepository:JobRepository
            ,step:Step,
    ): Job {
        return JobBuilder("BatchJob", jopRepository)
            .start(step)
            .incrementer(RunIdIncrementer())
            .build()
    }

}