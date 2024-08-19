package com.cjg.batchcsv.batch

import com.cjg.batchcsv.dto.Person
import com.google.gson.Gson
import org.springframework.batch.item.ItemProcessor
import org.springframework.context.annotation.Configuration

@Configuration
class PersonItemProcessor : ItemProcessor<Person, String> {

    override fun process(person:Person):String{

        val map = HashMap<String, Any>()

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

        map["index"] = person.index;
        map["customerId"] = person.customerId;
        map["firstName"] = person.firstName;
        map["lastName"] = person.lastName;
        map["company"] = person.company;
        map["city"] = person.city;
        map["country"] = person.country;
        map["phone1"] = person.phone1;
        map["phone2"] = person.phone2;
        map["email"] = person.email;
        map["subscriptionDate"] = person.subscriptionDate.toString();
        map["website"] = person.website;

        return Gson().toJson(map);
    }

}