package com.rai.gasto.rotas

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rai.gasto.data.repository.DespesaRepository
import com.rai.gasto.ui.adicionar.AdicionarDespesaScreen
import com.rai.gasto.ui.home.HomeScreen
import com.rai.gasto.ui.adicionar.AdicionarDespesaViewModel
import com.rai.gasto.ui.adicionar.AdicionarDespesaViewModelFactory
import com.rai.gasto.ui.home.HomeViewModel
import com.rai.gasto.ui.home.HomeViewModelFactory

@Composable
fun AppNavHost(repository: DespesaRepository) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.Home.route
    ) {

        composable(route = AppRoutes.Home.route) {
            val homeViewModel: HomeViewModel = viewModel(
                factory = HomeViewModelFactory(repository)
            )
            HomeScreen(
                onAdicionarDespesa = {
                    navController.navigate(AppRoutes.AdicionarDespesa.route)
                },
                viewModel = homeViewModel
            )
        }

        composable(route = AppRoutes.AdicionarDespesa.route) {
            val adicionarViewModel: AdicionarDespesaViewModel = viewModel(
                factory = AdicionarDespesaViewModelFactory(repository)
            )
            AdicionarDespesaScreen(
                onVoltar = {
                    navController.popBackStack()
                },
                viewModel = adicionarViewModel
            )
        }
    }
}