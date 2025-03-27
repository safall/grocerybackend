package com.whitecatlabs.grocery

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("GROCERIES")
data class Grocery(
    @Id val id: String? = null,
    val name: String
)
