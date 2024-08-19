package com.cjg.batchcsv.batch.config

import com.cjg.batchcsv.dto.Person
import org.springframework.batch.item.file.mapping.FieldSetMapper
import org.springframework.batch.item.file.transform.FieldSet
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class PersonFieldSetMapper : FieldSetMapper<Person> {
    override fun mapFieldSet(fieldSet: FieldSet): Person {

//        val index:Int
//        , val customerId: String
//        , val firstName: String
//        , val lastName: String
//        , val company: String
//        , val city: String
//        , val country: String
//        , val phone1: String
//        , val phone2: String
//        , val email: String
//        , val subscriptionDate: LocalDateTime
//        , val website: String

        val person = Person(
            fieldSet.readInt(0)
            , fieldSet.readString(1)
            , fieldSet.readString(2)
            , fieldSet.readString(3)
            , fieldSet.readString(4)
            , fieldSet.readString(5)
            , fieldSet.readString(6)
            , fieldSet.readString(7)
            , fieldSet.readString(8)
            , fieldSet.readString(9)
            , LocalDateTime.parse(fieldSet.readString(10) + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            , fieldSet.readString(11)
        );

        return person;
    }

}