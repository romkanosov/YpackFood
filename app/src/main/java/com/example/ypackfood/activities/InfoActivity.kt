package com.example.ypackfood.activities

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ypackfood.common.Constants.INFO_CONTENT
import com.example.ypackfood.common.Constants.PDPP
import com.example.ypackfood.components.*
import com.example.ypackfood.sealedClasses.Screens

@Composable
fun InfoScreen(
    navController: NavHostController
) {
    Scaffold (
        topBar = { ToolbarComponent(navController = navController, title = Screens.Info.title) },
        content = {
            LazyColumn(modifier = Modifier.padding(25.dp)) {
                val titleSize = 20.sp
                val contentSize = 16.sp
                val space = 30.dp

                item {
                    Text(text = "Описание", fontSize = titleSize)
                    Text(text = INFO_CONTENT, fontSize = contentSize, color = Color.Gray)
                    Spacer(modifier = Modifier.height(space))
                }

                item {
                    Text(text = "Наши контакты", fontSize = titleSize)
                    Text(text = "8800551196", fontSize = contentSize, color = Color.Gray)
                    Text(text = "+7863303386", fontSize = contentSize, color = Color.Gray)
                    Spacer(modifier = Modifier.height(space))
                }

                item {
                    Text(text = "Адрес", fontSize = titleSize)
                    Text(text = "Старая Станица, парк Лога", fontSize = contentSize, color = Color.Gray)
                    Spacer(modifier = Modifier.height(space))
                }

                item {
                    val uriHandler = LocalUriHandler.current
                    Text(text = "Нормативные документы", fontSize = titleSize)
                    Text(
                        modifier = Modifier.clickable {
                            uriHandler.openUri(PDPP)
                        },
                        text = "Политика конфиденциальности",
                        fontSize = contentSize,
                        color = Color.Blue,
                    )
                    //Text(text = "Пользовательское соглашение", fontSize = contentSize, color = Color.Blue)

                    Spacer(modifier = Modifier.height(space))

                }

                item {
                    Text(text = "Разработчики", fontSize = titleSize)
                    Text(text = "Андрияш Дмитрий (bironix@gmail.com)\r\nНосов Роман (revenger13@gmail.com)", fontSize = contentSize, color = Color.Gray)
                }
            }
        }
    )
}