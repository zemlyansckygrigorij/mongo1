package com.example.mongo1

import com.example.mongo1.models.Product
import com.example.mongo1.models.Propreties
import com.example.mongo1.services.ProductDAO
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Mongo1Application( private val productDAO: ProductDAO): ApplicationRunner {
	/* This will run after springboot full load*/
	override fun run(args: ApplicationArguments?) {
		this.createProduct()

	}

	private fun createProduct(){
		val property: Propreties = Propreties("MediaTek",
				"64 GB",
				"5 MP",
				"2800 mAh",
				"5 (12.7 cm)",
				"2 GB")

		val product = productDAO.insert(Product(name = "mobile",price=12.3,properties=property))
	}
	private fun cleanCollections(){
		productDAO.deleteAll()
	}
}

fun main(args: Array<String>) {
	runApplication<Mongo1Application>(*args)
}
