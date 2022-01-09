package com.mercadolivro.mercadolivro.repository

import com.mercadolivro.mercadolivro.model.PurchaseModel
import org.springframework.data.jpa.repository.JpaRepository

interface PurchaseRepository : JpaRepository<PurchaseModel, Int>
