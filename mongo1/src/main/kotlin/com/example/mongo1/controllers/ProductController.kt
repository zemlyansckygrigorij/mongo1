package com.example.mongo1.controllers

import com.example.mongo1.models.Author
import com.example.mongo1.models.Product
import com.example.mongo1.services.ProductService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController//declare this class as rest controller able to catch http request
@RequestMapping("api/product")//controller root path
class ProductController(private val productService: ProductService){//injects bookService by constructor

    @GetMapping
    fun getAll(pageable: Pageable): Page<Product> = productService.getAll(pageable)

    @GetMapping("{id}")  fun getById(@PathVariable id:String): Optional<Product> = productService.getById(id)

    @PostMapping
    fun insert(@RequestBody product: Product): Product = productService.insert(product)

    @PutMapping
    fun update(@RequestBody product: Product): Product = productService.update(product)

    @DeleteMapping("{id}")  fun deleteById(@PathVariable id: String): Optional<Product> = productService.deleteById(id)
}