package com.example.mongo1.services

import com.example.mongo1.models.Product
import com.example.mongo1.models.Propreties
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import javax.annotation.PostConstruct

internal class ProductServiceTest{
    private lateinit var propreties: Propreties
    private lateinit var productTest1: Product
    private lateinit var productTest2: Product

    @Autowired
    private lateinit var productDAO: ProductDAO
    private lateinit var id:String

    @PostConstruct
    @Bean
    fun init(productDAOInit: ProductDAO){
        productDAO = productDAOInit;
        propreties=Propreties(
                "MediaTek",
                "4 GB",
                "2 MP",
                "2000 mAh",
                "2.4 (6.1 cm)",
                "512 MB")
        productTest1 = Product(name = "test1",price=12.3,properties=propreties)
        productTest2 = Product(name = "test2",price=14.6,properties=propreties)
        id = productTest1.id.toString()
        //productDAO = ProductDAO
        productDAO.insert(productTest1)
        productDAO.insert(productTest2)
    }


    //@PostConstruct
    @BeforeEach
    fun setUp() {/*
        propreties=Propreties(
                "MediaTek",
                "4 GB",
                "2 MP",
                "2000 mAh",
                "2.4 (6.1 cm)",
                "512 MB")
        productTest1 = Product(name = "test1",price=12.3,properties=propreties)
        productTest2 = Product(name = "test2",price=14.6,properties=propreties)
        id = productTest1.id.toString()
        //productDAO = ProductDAO
        productDAO.insert(productTest1)
        productDAO.insert(productTest2)*/
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    @DisplayName("Should return the correct number products in collection")
    fun getAll() {
        val products = productDAO.findAll()
        println("Your Int Value is "+products.size);
        Assertions.assertThat(products.size).isEqualTo(2)
        //assertEquals(products.size, 2)
    }
/*
    @Test
    @DisplayName("Should return the object productTest1")
    fun getById() {
        val product = productDAO.findById(id)
        Assertions.assertThat(product).isEqualTo(productTest1)
    }

    @Test
    @DisplayName("Should increase collection on one object by class Product")
    fun insert() {
        val productTest3: Product = Product(name = "test3",price=15.8,properties=propreties)
        productDAO.insert(productTest3)
        val products = productDAO.findAll()
        assertEquals(products.size, 3)
    }
*/
  /*  @Test
    @DisplayName("Should update object ")
    fun update() {
        val product = productDAO.findById(id)
        product.
        Assertions.assertThat(product).isEqualTo(productTest1)
    }

    @Test
    fun deleteById() {
    }*/
}