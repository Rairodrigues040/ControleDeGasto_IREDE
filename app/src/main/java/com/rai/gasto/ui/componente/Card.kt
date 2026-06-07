package com.rai.gasto.ui.componente

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Card(
    titulo: String,
    valorTotal: Double,
    quantidadeCategorias: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp)
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF1B1B1B),
                            Color(0xFF111111)
                        )
                    )
                )
        ) {

            // Círculos decorativos
            Box(
                modifier = Modifier
                    .size(140.dp)
                    .offset(x = 50.dp, y = 10.dp)
                    .clip(CircleShape)
                    .background(
                        Color(0xFFB85C38).copy(alpha = 0.18f)
                    )
            )

            Box(
                modifier = Modifier
                    .size(150.dp)
                    .offset(x = 260.dp, y = (-20).dp)
                    .clip(CircleShape)
                    .background(
                        Color.White.copy(alpha = 0.04f)
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {

                Text(
                    text = titulo,
                    color = Color(0xFFA8A8A8),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.Bottom
                ) {

                    Text(
                        text = "R$",
                        color = Color.White,
                        fontSize = 18.sp
                    )

                    Spacer(Modifier.width(4.dp))

                    Text(
                        text = "$valorTotal",
                        color = Color.White,
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif
                    )
                }

                Spacer(Modifier.weight(1f))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    ChipInfo(
                        texto = "$quantidadeCategorias despesas",
                        corBolinha = Color(0xFFFF7A59)
                    )
                }
            }
        }
    }
}

@Composable
fun ChipInfo(
    texto: String,
    corBolinha: Color
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(Color(0xFF3A312D))
            .padding(
                horizontal = 12.dp,
                vertical = 4.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(4.dp)
                .clip(CircleShape)
                .background(corBolinha)
        )

        Spacer(Modifier.width(6.dp))

        Text(
            text = texto,
            color = Color.White,
            fontSize = 12.sp
        )
    }
}

@Preview
@Composable
private fun CardView() {
    Card(
        titulo = "Total gasto",
        valorTotal = 513.88,
        quantidadeCategorias = 6
    )
}