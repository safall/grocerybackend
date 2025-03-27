package com.whitecatlabs.grocery

import org.springframework.data.repository.CrudRepository

interface GroceryRepository : CrudRepository<Grocery, String>
