package com.cjg.batchcsv

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BatchCsvApplication

fun main(args: Array<String>) {
    runApplication<BatchCsvApplication>(*args)
}
