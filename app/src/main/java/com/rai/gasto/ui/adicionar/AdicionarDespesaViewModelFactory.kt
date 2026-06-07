package com.rai.gasto.ui.adicionar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rai.gasto.data.repository.DespesaRepository

class AdicionarDespesaViewModelFactory(
    private val repository: DespesaRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        return AdicionarDespesaViewModel(
            repository
        ) as T
    }
}