package com.example.demo.flyway.kt

import org.springframework.stereotype.Service

@Service
class CustomerService(val db: CustomerRepository){

    fun save(customer: Customer) {
        db.save(customer)
    }

}