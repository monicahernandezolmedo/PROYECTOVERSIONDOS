package com.example.proyectoversion1.modelo

data class Perfil(
    val nombre: String,
    val edad: Int,
    val pais: String,
    val genero: String,
    val fotoResourceId: Int? = null,
    val descripcion: String = "" // Nuevo campo de descripción
)
