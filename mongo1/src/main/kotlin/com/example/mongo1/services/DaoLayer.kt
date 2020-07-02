package com.example.mongo1.services


import com.example.mongo1.models.Product
import org.springframework.data.mongodb.repository.MongoRepository


interface ProductDAO:MongoRepository<Product,String>

