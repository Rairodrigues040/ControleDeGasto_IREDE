package com.rai.gasto.rotas

sealed class AppRoutes(
    val route: String
) {

    data object Home : AppRoutes(
        route = "home"
    )

    data object AdicionarDespesa : AppRoutes(
        route = "adicionar_despesa"
    )
}