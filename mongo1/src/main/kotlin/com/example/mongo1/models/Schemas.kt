package com.example.mongo1.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document data class Product(@Id val id:String? = null,val name:String,val price:Double, val properties:Propreties)

