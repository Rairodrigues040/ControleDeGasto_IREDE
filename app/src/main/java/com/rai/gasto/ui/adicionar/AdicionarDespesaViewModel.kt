package com.rai.gasto.ui.adicionar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rai.gasto.data.local.DespesaEntity
import com.rai.gasto.data.model.Categoria
import com.rai.gasto.data.repository.DespesaRepository
import com.rai.gasto.ui.adicionar.AdicionarDespesaUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AdicionarDespesaViewModel(
    private val repository: DespesaRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(AdicionarDespesaUiState())

    val uiState =
        _uiState.asStateFlow()

    init {
        carregarCategorias()
    }

    private fun carregarCategorias() {

        val categorias = listOf(
            Categoria(
                id = 1,
                nome = "Lazer"
            ),
            Categoria(
                id = 2,
                nome = "Transporte"
            ),
            Categoria(
                id = 3,
                nome = "Alimentação",
            )
        )

        _uiState.update {

            it.copy(
                categorias = categorias,
                categoriaSelecionada = categorias.first()
            )
        }
    }

    fun atualizarDescricao(descricao: String) {

        _uiState.update {

            it.copy(
                descricao = descricao
            )
        }
    }

    fun atualizarValor(valor: String) {

        _uiState.update {

            it.copy(
                valor = valor
            )
        }
    }

    fun selecionarCategoria(
        categoria: Categoria
    ) {

        _uiState.update {

            it.copy(
                categoriaSelecionada = categoria
            )
        }
    }

    private fun camposValidos(): Boolean {

        val estado = _uiState.value

        return estado.descricao.isNotBlank() &&
                estado.valor.isNotBlank() &&
                estado.categoriaSelecionada != null
    }

    fun salvarDespesa() {

        if (!camposValidos()) {
            return
        }

        val estado = _uiState.value

        val valor = estado.valor
            .replace(",", ".")
            .toDoubleOrNull()

        if (valor == null) {
            return
        }

        viewModelScope.launch {

            repository.inserirDespesa(

                DespesaEntity(
                    descricao = estado.descricao,
                    valor = valor,
                    categoriaId = estado.categoriaSelecionada!!.id
                )
            )

            _uiState.update {

                it.copy(
                    descricao = "",
                    valor = ""
                )
            }
        }
    }
}