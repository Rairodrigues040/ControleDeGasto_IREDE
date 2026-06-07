package com.rai.gasto.ui.adicionar

import com.rai.gasto.data.model.Categoria

data class AdicionarDespesaUiState(
    val descricao: String = "",
    val valor: String = "",
    val categorias: List<Categoria> = emptyList(),
    val categoriaSelecionada: Categoria? = null,
    val carregando: Boolean = false
)