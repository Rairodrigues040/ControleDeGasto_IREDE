package com.rai.gasto.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rai.gasto.data.local.DespesaEntity
import com.rai.gasto.data.model.Categoria
import com.rai.gasto.data.model.Despesa
import com.rai.gasto.data.repository.DespesaRepository
import com.rai.gasto.ui.home.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: DespesaRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    val categorias = listOf(
        Categoria(id = 1, nome = "Lazer"),
        Categoria(id = 2, nome = "Transporte"),
        Categoria(id = 3, nome = "Alimentação")
    )

    init {
        // Inicializa as categorias no estado da UI
        _uiState.update {
            it.copy(
                categorias = categorias,
                quantidadeCategorias = categorias.size
            )
        }
        carregarDadosRealTime()
    }

    private fun carregarDadosRealTime() {
        viewModelScope.launch {
            repository.listarDespesas().collect { despesasEntity ->
                // Converte de DespesaEntity (Banco) para Despesa (UI)
                val listaDespesas = despesasEntity.map {
                    Despesa(
                        id = it.id,
                        descricao = it.descricao,
                        valor = it.valor,
                        categoriaId = it.categoriaId
                    )
                }

                _uiState.update { estadoAtual ->
                    // Aplica a filtragem baseada na categoria selecionada no momento
                    val filtradas = if (estadoAtual.categoriaSelecionada == null) {
                        listaDespesas
                    } else {
                        listaDespesas.filter { it.categoriaId == estadoAtual.categoriaSelecionada }
                    }

                    estadoAtual.copy(
                        despesas = listaDespesas,
                        despesasFiltradas = filtradas,
                        valorTotal = listaDespesas.sumOf { it.valor }
                    )
                }
            }
        }
    }

    fun selecionarCategoria(categoriaId: Long?) {
        _uiState.update { estadoAtual ->
            val filtradas = if (categoriaId == null) {
                estadoAtual.despesas
            } else {
                estadoAtual.despesas.filter { it.categoriaId == categoriaId }
            }
            estadoAtual.copy(
                categoriaSelecionada = categoriaId,
                despesasFiltradas = filtradas
            )
        }
    }

    fun removerDespesa(despesa: Despesa) {
        viewModelScope.launch {
            repository.removerDespesa(
                DespesaEntity(
                    id = despesa.id,
                    descricao = despesa.descricao,
                    valor = despesa.valor,
                    categoriaId = despesa.categoriaId
                )
            )
        }
    }
}