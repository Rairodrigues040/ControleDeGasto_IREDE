package com.rai.gasto.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "despesas")
data class DespesaEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val descricao: String,
    val valor: Double,
    val categoriaId: Long
)