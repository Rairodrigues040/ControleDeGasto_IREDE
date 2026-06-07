package com.rai.gasto.ui.componente

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rai.gasto.data.model.Despesa

@Composable
fun DespesaItem(
    despesa: Despesa,
    onRemover: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically // Alinha os textos e o ícone no centro
        ) {
            Column {
                Text(
                    text = despesa.descricao,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "R$ %.2f".format(despesa.valor),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            IconButton(onClick = onRemover) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Remover despesa",
                    tint = MaterialTheme.colorScheme.error // Deixa a lixeira vermelha
                )
            }
        }
    }
}