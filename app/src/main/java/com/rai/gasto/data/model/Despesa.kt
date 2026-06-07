package com.rai.gasto.data.model

data class Despesa(
    val id: Long,
    val descricao: String,
    val valor: Double,
    val categoriaId: Long
)