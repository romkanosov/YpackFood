package com.example.ypackfood.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartEntity(
    @ColumnInfo(name = "dish_id") val dishId: Int,
    @ColumnInfo(name = "user_id") val userId: Int,
    @ColumnInfo(name = "portion_id") val portionId: Int,
    @ColumnInfo(name = "dish_price_id") val dishPriceId: Int,
    @ColumnInfo(name = "dish_price") val dishPrice: Int,
    @ColumnInfo(name = "dish_count") val dishCount: Int,

    @PrimaryKey(autoGenerate = true) val shoppingCartId: Int? = null
)
//{
//    //@PrimaryKey(autoGenerate = true) var shoppingCartId: Int? = null
//}