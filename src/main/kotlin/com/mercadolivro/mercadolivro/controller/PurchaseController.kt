package com.mercadolivro.mercadolivro.controller

import com.mercadolivro.mercadolivro.controller.mapper.PurchaseMapper
import com.mercadolivro.mercadolivro.controller.request.PostPurchaseRequest
import com.mercadolivro.mercadolivro.controller.response.PurchaseBookResponse
import com.mercadolivro.mercadolivro.service.PurchaseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("purchases")
class PurchaseController(
    private val purchaseService: PurchaseService,
    private val purchaseMapper: PurchaseMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody request: PostPurchaseRequest): PurchaseBookResponse {
        return purchaseService.create(purchaseMapper.toModel(request))
    }
}