package com.rai.gasto.data.repository


import com.rai.gasto.data.local.DespesaDao
import com.rai.gasto.data.local.DespesaEntity
import kotlinx.coroutines.flow.Flow

class DespesaRepository(
    private val despesaDao: DespesaDao
) {

    fun listarDespesas(): Flow<List<DespesaEntity>> {
        return despesaDao.listarTodas()
    }

    suspend fun inserirDespesa(
        despesa: DespesaEntity
    ) {
        despesaDao.inserir(despesa)
    }

    suspend fun removerDespesa(
        despesa: DespesaEntity
    ) {
        despesaDao.deletar(despesa)
    }
}