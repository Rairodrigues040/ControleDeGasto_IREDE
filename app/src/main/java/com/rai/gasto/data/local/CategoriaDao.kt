package com.rai.gasto.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rai.gasto.data.local.CategoriaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoriaDao {

    @Insert
    suspend fun inserir(
        categoria: CategoriaEntity
    )

    @Query("SELECT * FROM categorias")
    fun listarTodas(): Flow<List<CategoriaEntity>>
}