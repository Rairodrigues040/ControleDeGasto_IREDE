package com.rai.gasto.ui.adicionar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rai.gasto.ui.adicionar.AdicionarDespesaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdicionarDespesaScreen(
    onVoltar: () -> Unit,
    viewModel: AdicionarDespesaViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    var expandido by remember {
        mutableStateOf(false)
    }

    Scaffold(

        topBar = {

            TopAppBar(
                title = {
                    Text("Nova Despesa")
                },

                navigationIcon = {

                    IconButton(
                        onClick = onVoltar
                    ) {

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),

            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = "Descrição",
                style = MaterialTheme.typography.labelLarge
            )

            OutlinedTextField(
                value = uiState.descricao,
                onValueChange = {
                    viewModel.atualizarDescricao(it)
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text("Ex: McDonald's")
                },
                singleLine = true
            )

            Text(
                text = "Valor",
                style = MaterialTheme.typography.labelLarge
            )

            OutlinedTextField(
                value = uiState.valor,
                onValueChange = {
                    viewModel.atualizarValor(it)
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text("Ex: 35,00")
                },
                singleLine = true
            )

            Text(
                text = "Categoria",
                style = MaterialTheme.typography.labelLarge
            )

            ExposedDropdownMenuBox(
                expanded = expandido,
                onExpandedChange = {
                    expandido = !expandido
                }
            ) {

                OutlinedTextField(
                    value = uiState.categoriaSelecionada?.nome ?: "",
                    onValueChange = {},
                    readOnly = true,

                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),

                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = expandido
                        )
                    }
                )

                ExposedDropdownMenu(
                    expanded = expandido,
                    onDismissRequest = {
                        expandido = false
                    }
                ) {

                    uiState.categorias.forEach { categoria ->

                        DropdownMenuItem(

                            text = {
                                Text(categoria.nome)
                            },

                            onClick = {

                                viewModel.selecionarCategoria(categoria)
                                expandido = false
                            }
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = {

                    viewModel.salvarDespesa()

                    onVoltar()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {

                Text("Salvar")
            }
        }
    }
}