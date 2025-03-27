package com.whitecatlabs.grocery

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/")
class GroceryController(private val service: GroceryService) {
    @GetMapping
    fun groceries() = service.findGroceries()

    @PostMapping
    fun post(@RequestBody grocery: Grocery): ResponseEntity<Grocery> {
        val savedMessage = service.save(grocery)
        return ResponseEntity.created(URI("/${savedMessage.id}")).body(savedMessage)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: String): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{id}")
    fun getMessage(@PathVariable id: String): ResponseEntity<Grocery> {
        return service.findGroceriesById(id).toResponseEntity()
    }

    private fun Grocery?.toResponseEntity(): ResponseEntity<Grocery> {
        return this?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }
}
