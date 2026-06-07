package com.rai.gasto.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categorias")
data class CategoriaEntity(

    @PrimaryKey
    val id: Long,

    val nome: String
)