package com.rai.gasto.ui.componente


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CategoriaChip(
    nome: String,
    selecionada: Boolean,
    onClick: () -> Unit
) {

    FilterChip(
        selected = selecionada,
        onClick = onClick,
        label = {
            Text(nome)
        },
        modifier = Modifier.padding(end = 8.dp)
    )
}

@Preview
@Composable
private fun CategoriaChipView() {
    CategoriaChip(
        nome = "Rai",
        selecionada = false,
        onClick = {}
    )
}