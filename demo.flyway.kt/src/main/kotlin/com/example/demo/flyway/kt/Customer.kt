package com.example.demo.flyway.kt



import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id


@Entity
data class Customer (@Id var id: String, var name: String)