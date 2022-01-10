package com.mercadolivro.mercadolivro.controller.response

data class PageResponse<T>(
    val items: List<T>,
    var currentPage: Int,
    var totalItems: Long,
    var totalPages: Int
)
