package com.example.ypackfood.sealedClasses

import com.example.ypackfood.common.Constants

sealed class Screens(val route: String) {
    object Main: Screens(route = "MainScreen")
    object DetailContent: Screens(route = "DetailContentScreen/{${Constants.NAV_KEY__CONTENT_ID}}") {
        fun createRoute(contentId: Int) = this.route.replace(oldValue = "{${Constants.NAV_KEY__CONTENT_ID}}", newValue = contentId.toString())
    }
    object SignInUp: Screens(route = "SignInUpScreen")
    object Offers: Screens(route = "OffersScreen")
    object ShoppingCart: Screens(route = "ShoppingCartScreen")
    object History: Screens(route = "HistoryScreen")
    object Profile: Screens(route = "ProfileScreen")
}
