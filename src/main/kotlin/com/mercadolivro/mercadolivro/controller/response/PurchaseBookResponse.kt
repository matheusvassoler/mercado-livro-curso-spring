package com.mercadolivro.mercadolivro.controller.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.mercadolivro.mercadolivro.model.BookModel

data class PurchaseBookResponse(
    val message: String,
    @JsonProperty("purchase_book")
    val successSoldBook: List<BookModel>? = null,
    @JsonProperty("books_not_available")
    val failedSoldBook: List<BookModel>? = null
)