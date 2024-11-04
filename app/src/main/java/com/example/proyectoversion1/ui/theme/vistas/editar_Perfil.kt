package com.example.proyectoversion1.ui.theme.vistas


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.proyectoversion1.R
import com.example.proyectoversion1.modelo.Perfil
import com.example.proyectoversion1.navegacion.BottomCircles

@Composable
fun EditProfileView(perfil: Perfil, navController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            ChatTopAppBar()
        },
        bottomBar = {
            BottomCircles(navController) // Pasar el NavController aquí
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues, modifier = modifier.fillMaxSize()) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color.LightGray)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = perfil.fotoResourceId ?: R.drawable.ic_launcher_background),
                        contentDescription = "Imagen de perfil",
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .size(66.dp)
                        .background(Color.Gray)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "+", style = MaterialTheme.typography.displayMedium, color = Color.White)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Nombre: ${perfil.nombre}", modifier = Modifier.padding(8.dp))
                Text(text = "Edad: ${perfil.edad}", modifier = Modifier.padding(8.dp))
                Text(text = "Género: ${perfil.genero}", modifier = Modifier.padding(8.dp))

                Text(text = "Descripción:", modifier = Modifier.padding(8.dp))
                TextField(
                    value = remember { TextFieldValue(perfil.descripcion) },
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    placeholder = { Text("Escribe una descripción...") }
                )
            }
        }
    }
}
/*
@Preview(showBackground = true)
@Composable
fun ShowEditProfileView() {
    EditProfileView(
        perfil = Perfil("Juan Pérez", 25, "México", "Masculino", null, "Descripción del perfil.")
    )
}

 */

