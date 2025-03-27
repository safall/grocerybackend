package com.whitecatlabs.grocery

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GroceryService(private val repository: GroceryRepository) {
    fun findGroceries(): List<Grocery> = repository.findAll().toList()

    fun findGroceriesById(id: String): Grocery? = repository.findByIdOrNull(id)

    fun save(grocery: Grocery) = repository.save(grocery)

    fun delete(id: String) = repository.deleteById(id)
}
