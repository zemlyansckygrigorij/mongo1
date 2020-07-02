package com.example.mongo1.services

import com.example.mongo1.models.Product
import com.example.mongo1.util.BasicCrud
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service//declare this class as a Service "Component specialization"
/*injects DAO objects by constructor & implements BasicCrud interface*/
class ProductService(private val productDAO: ProductDAO):BasicCrud<String, Product>{
    override fun getAll(pageable: Pageable): Page<Product>  = productDAO.findAll(pageable)

    override fun getById(id: String): Optional<Product> = productDAO.findById(id)

    override fun insert(obj: Product): Product = productDAO.insert(obj)

    @Throws(Exception::class)
    override fun update(obj: Product): Product {
        return if(obj.id?.let { productDAO.existsById(it) }!!){//check if author exists because the save method will insert a record if does not exists
            productDAO.save(obj).apply { //update author

            }
        }else{
            throw object : Exception("The author does not exists"){}
        }
    }

    override fun deleteById(id: String): Optional<Product> {
        return productDAO.findById(id).apply {
            this.ifPresent {
                productDAO.delete(it)
            }
        }
    }
}


