package com.rai.gasto.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.rai.gasto.data.local.DespesaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DespesaDao {

    @Insert
    suspend fun inserir(
        despesa: DespesaEntity
    )

    @Delete
    suspend fun deletar(
        despesa: DespesaEntity
    )

    @Query("SELECT * FROM despesas")
    fun listarTodas(): Flow<List<DespesaEntity>>
}