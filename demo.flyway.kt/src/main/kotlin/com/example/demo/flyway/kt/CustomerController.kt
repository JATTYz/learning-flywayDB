package com.example.demo.flyway.kt

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class CustomerController(val service: CustomerService) {
    var logger: Logger = LoggerFactory.getLogger(CustomerController::class.java)
    @GetMapping("/")
    fun index(@RequestParam("name") name: String) = "HELLO $name!, WELCOME TO MY WORLD"
    @GetMapping("/customer")
    fun getCustomer() = listOf(
        Customer("1","JO"),
        Customer("2","JAMES"),
        Customer("3","JOHN")
    )
    @PostMapping("/test")
    fun createCustomer(@RequestBody name: String): ResponseEntity<String>{
        var header = HttpHeaders();
        header.add("Custom-Header", "FOO")

        logger.info("This is info message")
        service.save(Customer(UUID.randomUUID().toString(),name))
        return ResponseEntity("You have created a new customer and set new header", header ,HttpStatus.CREATED)
    }


}