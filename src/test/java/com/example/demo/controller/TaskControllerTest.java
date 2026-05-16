package com.example.demo.controller;
// ==========================================================
// 1. IMPORTACIONES CORRECTAS (una por una, explicadas)
// ==========================================================

// Para @Test - le dice a JUnit que esto es una prueba
import org.junit.jupiter.api.Test;

// Para @DisplayName - da nombre legible a la prueba
import org.junit.jupiter.api.DisplayName;

// Para @Autowired - Spring inyecta dependencias
import org.springframework.beans.factory.annotation.Autowired;

// Para @SpringBootTest - LEVANTA TODO SPRING (IMPORTANTE - TE FALTABA)
import org.springframework.boot.test.context.SpringBootTest;

// Para @AutoConfigureMockMvc - configura MockMvc automáticamente
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

// Para MediaType - constantes como "application/json"
import org.springframework.http.MediaType;

// Para MockMvc - el objeto que simula peticiones HTTP
import org.springframework.test.web.servlet.MockMvc;

// Para post() - el método para hacer peticiones POST
// IMPORTANTE: viene de MockMvcRequestBuilders, NO de RequestEntity
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

// Para status() - verifica códigos HTTP (isOk, isBadRequest, etc.)
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Para jsonPath() - busca campos en respuestas JSON
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


// ==========================================================
// 2. CLASE DE PRUEBA CORRECTA
// ==========================================================

@SpringBootTest                      // ← Le faltaba esto: levanta Spring
@AutoConfigureMockMvc                // ← Configura MockMvc
class TaskControllerTest {

    @Autowired                       // ← Spring inyecta MockMvc
    private MockMvc mockMvc;

    @Test
    @DisplayName("🔴 ROJO: Debería crear tarea con título válido")
    void deberiaCrearTareaConTituloValido() throws Exception {

        // ==========================================================
        // PARTE 1: PREPARAR (Given)
        // ==========================================================
        // Definimos el título que vamos a enviar
        String tareaJson = """
            {
                "titulo": "Aprender TDD",
                "fechaCreacion": "2026-05-15"
            }
            """;

        // ==========================================================
        // PARTE 2: EJECUTAR (When)
        // ==========================================================
        mockMvc.perform(                    // Ejecutamos la simulación
                        post("/task/guardar")                  // POST a /tasks
                                .contentType(MediaType.APPLICATION_JSON)  // Tipo: JSON
                                .content(tareaJson)
                        )
                // Cuerpo: "Aprender TDD" (con comillas)
                // ==========================================================
                // PARTE 3: VERIFICAR (Then)
                // ==========================================================
                .andExpect(status().isOk())         // Esperamos HTTP 200
                .andExpect(jsonPath("$.titulo").value("Aprender TDD"));  // Esperamos ese título
    }
}