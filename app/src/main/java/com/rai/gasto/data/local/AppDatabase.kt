package com.rai.gasto.data.local

import com.rai.gasto.data.local.CategoriaDao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.rai.gasto.data.local.CategoriaEntity
import com.rai.gasto.data.local.DespesaDao
import com.rai.gasto.data.local.DespesaEntity

@Database(
    entities = [
        CategoriaEntity::class,
        DespesaEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoriaDao(): CategoriaDao

    abstract fun despesaDao(): DespesaDao
}