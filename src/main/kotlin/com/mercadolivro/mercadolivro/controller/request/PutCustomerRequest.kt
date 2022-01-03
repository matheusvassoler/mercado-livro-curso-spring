package com.mercadolivro.mercadolivro.controller.request

import com.mercadolivro.mercadolivro.model.CustomerModel

data class PutCustomerRequest(
    var name: String,
    var email: String
)