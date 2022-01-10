package com.mercadolivro.mercadolivro.controller

import com.mercadolivro.mercadolivro.controller.response.CustomerResponse
import com.mercadolivro.mercadolivro.extension.toResponse
import com.mercadolivro.mercadolivro.service.CustomerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("admin")
class AdminController() {

    @GetMapping("/reports")
    fun report(): String {
        return "This is a Report. Only Admin can see it!"
    }

}