package com.example.ypackfood.activities

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ypackfood.components.*
import com.example.ypackfood.models.commonData.Dish
import com.example.ypackfood.sealedClasses.Screens
import com.example.ypackfood.viewModels.FavoritesViewModel
import com.example.ypackfood.viewModels.RoomViewModel

@Composable
fun FavoritesScreen(navController: NavHostController, favoritesViewModel: FavoritesViewModel, roomViewModel: RoomViewModel) {

    val favorites = roomViewModel.favorites.observeAsState(listOf()).value
    val requestState = favoritesViewModel.favoritesState.observeAsState().value
    val deletingDishList = roomViewModel.deletingFavListState

    LaunchedEffect(true) {
        favoritesViewModel.initContentResp()
    }

    LaunchedEffect(favorites) {
        if (favorites.isNotEmpty()) {
            favoritesViewModel.getContentByListId(
                contentIdList = favorites,
                roomViewModel = roomViewModel
            )
        }
    }

    LaunchedEffect(deletingDishList) {
        if (deletingDishList.isNotEmpty()) {
            roomViewModel.deleteFromFavoritesByListId(deletingDishList)
        }
    }

    Scaffold (
        topBar = {
            ToolbarComponent(navController = navController, title = Screens.Favorites.title)
        },
        content = {
            Column(modifier = Modifier.padding(horizontal = 15.dp)) {
                if (!favorites.isNullOrEmpty()) {
                    if (!requestState?.data.isNullOrEmpty()) {
                        Log.d("networkAnswer", "Display data")
                        ContentSimpleListComponent(
                            contentList = requestState!!.data!! as List<Dish>,
                            showPrice = true,
                            onItemClick = { id -> navController.navigate(route = Screens.DetailContent.createRoute(contentId = id)) }
                        )
                    }
                } else {
                    EmptyContentComponent(message = "У Вас пока что нет любимых блюд")
                }


                RequestStateComponent(
                    requestState = requestState,
                    byError = {
                        ShowErrorComponent(
                            message = requestState?.message,
                            onButtonClick = {
                                favoritesViewModel.getContentByListId(
                                    contentIdList = favorites,
                                    roomViewModel = roomViewModel
                                )
                            }
                        )
                    }
                )
            }
        }
    )
}