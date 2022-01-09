package com.mercadolivro.mercadolivro.service

import com.mercadolivro.mercadolivro.controller.response.PurchaseBookResponse
import com.mercadolivro.mercadolivro.enums.BookStatus
import com.mercadolivro.mercadolivro.events.PurchaseEvent
import com.mercadolivro.mercadolivro.exception.BadRequestException
import com.mercadolivro.mercadolivro.model.BookModel
import com.mercadolivro.mercadolivro.model.PurchaseModel
import com.mercadolivro.mercadolivro.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun create(purchaseModel: PurchaseModel): PurchaseBookResponse {
        val validBooksToBuy: MutableList<BookModel> = mutableListOf()
        val invalidBooksToBuy: MutableList<BookModel> = mutableListOf()
        for (book in purchaseModel.books) {
            book.status?.let {
                if (it == BookStatus.ATIVO) {
                    validBooksToBuy.add(book)
                } else {
                    invalidBooksToBuy.add(book)
                }
            }
        }
        if (validBooksToBuy.isEmpty()) {
            throw BadRequestException("Os livros a serem comprados não estão disponveis", "ML23232")
        }
        purchaseRepository.save(purchaseModel.copy(books = validBooksToBuy))

        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))

        return if (invalidBooksToBuy.isNotEmpty()) {
            PurchaseBookResponse(
                "Alguns livros não pudeream ser comprado, pois não estão disponiveis",
                successSoldBook = validBooksToBuy,
                failedSoldBook = invalidBooksToBuy
            )
        } else {
            PurchaseBookResponse("Livros adquiridos com sucesso")
        }
    }

    fun update(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }
}
