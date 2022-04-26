package com.example.ypackfood.models.detailContent

import com.example.ypackfood.models.commonData.BasePortion
import com.example.ypackfood.models.commonData.Dish
import com.example.ypackfood.models.commonData.PicturePaths

data class DetailContent(
    val addons: List<Addon>,
    val allergens: String,
    val basePortion: BasePortion,
    val category: String,
    val composition: String,
    val deleted: Boolean,
    val description: String,
    val dishes: List<Dish>,
    val id: Int,
    val name: String,
    val picturePaths: PicturePaths,
    val portions: List<Portion>
)