package com.rai.gasto.ui.home

import com.rai.gasto.data.model.Categoria
import com.rai.gasto.data.model.Despesa

data class HomeUiState(
    val valorTotal: Double = 0.0,
    val quantidadeCategorias: Int = 0,
    val categorias: List<Categoria> = emptyList(),
    val despesas: List<Despesa> = emptyList(),
    val despesasFiltradas: List<Despesa> = emptyList(),
    val categoriaSelecionada: Long? = null
)