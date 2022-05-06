package com.example.ypackfood.retrofit

import com.example.ypackfood.common.Constants.HEADER_AUTH
import com.example.ypackfood.models.actionsContent.ActionsItem
import com.example.ypackfood.models.commonData.Dish
import com.example.ypackfood.models.detailAction.DetailAction
import com.example.ypackfood.models.detailContent.DetailContent
import com.example.ypackfood.models.mainContent.Category
import com.example.ypackfood.models.temp.OrderFull.Order
import com.example.ypackfood.models.temp.OrderMin
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("dishes")
    suspend fun getMainContent(@Header(HEADER_AUTH) token: String): Response<MutableList<Category>>

    @GET("actions")
    suspend fun getActions(@Header(HEADER_AUTH) token: String): Response<MutableList<ActionsItem>>

    @GET("dishes/{dishId}")
    suspend fun getDetailContent(
        @Header(HEADER_AUTH) token: String,
        @Path("dishId") dishId: Int
    ): Response<DetailContent>

    @GET("actions/{actionId}")
    suspend fun getDetailAction(
        @Header(HEADER_AUTH) token: String,
        @Path("actionId") actionId: Int
    ): Response<DetailAction>

    @GET("specificDishes")
    suspend fun getContentByListId(
        @Header(HEADER_AUTH) token: String,
        @Query("ids") contentIdList: List<Int>
    ): Response<MutableList<Dish>>

    @POST("my/orders")
    suspend fun createOrder(
        @Header(HEADER_AUTH) token: String,
        @Body order: OrderMin
    ): Response<Order>
}
//@GET("hello")
//suspend fun getHello(): Response<String>
//
//@GET("credit_card?details=")
//suspend fun getCard(@Query("details") details_card: String): Response<String>
//
//@GET("path/{number}")
//suspend fun getPath(@Path("number") number: Int): Response<String>
//
//@GET("body_value")
//suspend fun getBody(@Query("body_value") body_value: String): Response<String>
//
//@GET("teapot")
//suspend fun getTea(): Response<String>
//
//@GET("error1")
//suspend fun getError(): Response<String>