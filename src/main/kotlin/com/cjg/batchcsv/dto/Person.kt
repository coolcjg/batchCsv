package com.cjg.batchcsv.dto

import java.io.Serializable
import java.time.LocalDateTime

data class Person(
    val index:Int
    , val customerId: String
    , val firstName: String
    , val lastName: String
    , val company: String
    , val city: String
    , val country: String
    , val phone1: String
    , val phone2: String
    , val email: String
    , val subscriptionDate:LocalDateTime
    , val website: String
): Serializable {
    var add:String?= null
}