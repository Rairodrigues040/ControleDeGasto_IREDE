package com.rai.gasto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.rai.gasto.data.local.AppDatabase
import com.rai.gasto.data.repository.DespesaRepository
import com.rai.gasto.rotas.AppNavHost
import com.rai.gasto.ui.theme.GastoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Constrói o banco de dados do Room
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "banco_gastos"
        ).build()

        // 2. Cria o repositório
        val repository = DespesaRepository(db.despesaDao())

        setContent {
            GastoTheme {
                // 3. Passa o repositório para a navegação
                AppNavHost(repository = repository)
            }
        }
    }
}