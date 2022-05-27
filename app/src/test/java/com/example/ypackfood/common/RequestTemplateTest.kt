package com.example.ypackfood.common

import android.util.Log
import com.example.ypackfood.common.Constants.PERSON_ID_DEFAULT
import com.example.ypackfood.common.RequestTemplate.buildDishInfo
import com.example.ypackfood.room.entities.CartEntity
import org.junit.Assert.*

import org.junit.Test

class RequestTemplateTest {

    @Test
    fun buildDishInfoTest() {
        val dishId = 1
        val userId = PERSON_ID_DEFAULT
        val portionId = 10
        val priceId = 13
        val price = 1500
        val count = 5


        val composedCart = buildDishInfo(
            dishId = dishId,
            portionId = portionId,
            priceId = priceId,
            price = price,
            count = count
        )

        val wishedCart = CartEntity(
            dishId = dishId,
            userId = userId ,
            portionId = portionId,
            dishPriceId = priceId,
            dishPrice = price,
            dishCount = count
        )
        assertTrue(composedCart == wishedCart)
    }
}