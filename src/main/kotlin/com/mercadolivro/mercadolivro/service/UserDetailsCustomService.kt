package com.mercadolivro.mercadolivro.service

import com.mercadolivro.mercadolivro.exception.AuthenticationException
import com.mercadolivro.mercadolivro.repository.CustomerRepository
import com.mercadolivro.mercadolivro.security.UserCustomDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsCustomService(
    private val customerRepository: CustomerRepository
) : UserDetailsService {

    override fun loadUserByUsername(id: String): UserDetails {
        val customer = customerRepository.findById(id.toInt())
            .orElseThrow{ AuthenticationException("Usuario nao encontrado", "9999") }
        return UserCustomDetails(customer)
    }

}