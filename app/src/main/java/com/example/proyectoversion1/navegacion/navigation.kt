package com.example.proyectoversion1.navegacion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoversion1.ui.theme.vistas.ChatProfileList
import com.example.proyectoversion1.ui.theme.vistas.EditProfileView
import com.example.proyectoversion1.ui.theme.vistas.VideoChatScreen
import com.example.proyectoversion1.modelo.Perfil
@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "chat") {
        composable("chat") {
            ChatProfileList(
                perfilList = listOf(
                    Perfil("Juan Pérez", 25, "México", "Masculino", null, "Descripción del perfil."),
                    Perfil("María López", 30, "Argentina", "Femenino", null, "Descripción del perfil."),
                    Perfil("Carlos Gómez", 28, "Colombia", "Masculino", null, "Descripción del perfil.")
                ),
                navController = navController // Pasar el navController aquí
            )
        }
        composable("videoChat") { VideoChatScreen(navController = navController) } // Pasar el navController aquí
        composable("editProfile") {
            EditProfileView(
                perfil = Perfil("Juan Pérez", 25, "México", "Masculino", null, "Descripción del perfil."),
                navController = navController // Pasar el navController aquí
            )
        }
    }

    // Si quieres que BottomCircles esté en una parte específica, quizás deberías ponerlo aquí
    BottomCircles(navController)
}


@Composable
fun BottomCircles(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Círculo para el chat
        IconButton(onClick = { navController.navigate("chat") }) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text("Chat", color = Color.White) // O usa un icono
            }
        }

        // Círculo para el video chat
        IconButton(onClick = { navController.navigate("videoChat") }) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text("Video", color = Color.White) // O usa un icono
            }
        }

        // Círculo para editar perfil
        IconButton(onClick = { navController.navigate("editProfile") }) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text("Edit", color = Color.White) // O usa un icono
            }
        }
    }
}
