package com.rai.gasto.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rai.gasto.ui.componente.Card
import com.rai.gasto.ui.componente.CategoriaChip
import com.rai.gasto.ui.componente.DespesaItem
import com.rai.gasto.ui.home.HomeViewModel

@Composable
fun HomeScreen(
    onAdicionarDespesa: () -> Unit,
    viewModel: HomeViewModel
) {
    // Coleta o estado reativo do ViewModel
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAdicionarDespesa
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Adicionar despesa"
                )
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Controle de Gastos",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,

            )

            Card(
                titulo = "Total de Gastos",
                valorTotal = uiState.valorTotal,
                quantidadeCategorias = uiState.quantidadeCategorias
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow {
                item {
                    CategoriaChip(
                        nome = "Todos",
                        selecionada = uiState.categoriaSelecionada == null,
                        onClick = {
                            viewModel.selecionarCategoria(null)
                        }
                    )
                }

                items(uiState.categorias) { categoria ->
                    CategoriaChip(
                        nome = categoria.nome,
                        selecionada = uiState.categoriaSelecionada == categoria.id,
                        onClick = {
                            viewModel.selecionarCategoria(categoria.id)
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(uiState.despesasFiltradas) { despesa ->
                    DespesaItem(
                        despesa = despesa,
                        onRemover = {
                            viewModel.removerDespesa(despesa)
                        }
                    )
                }
            }
        }
    }
}