package com.example.demo.controller;

// ==========================================================
// IMPORTACIONES
// ==========================================================

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// ==========================================================
// CLASE DE PRUEBA
// ==========================================================

@SpringBootTest
@AutoConfigureMockMvc
class DocumentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // CREATE
    @Test
    @DisplayName("🟢 CREATE: Debería crear documento")
    void deberiaCrearDocumento() throws Exception {

        String documentoJson = """
            {
                "nombreDocumento": "Formato único de Trámite",
                "activo": true
            }
            """;

        mockMvc.perform(
                        post("/documento/guardar")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(documentoJson)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDocumento")
                        .value("Formato único de Trámite"));
    }

    // READ
    @Test
    @DisplayName("🔵 READ: Debería listar documentos")
    void deberiaListarDocumentos() throws Exception {

        mockMvc.perform(
                        get("/documento/listar")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(5));
    }

    // UPDATE
    @Test
    @DisplayName("🟡 UPDATE: Debería actualizar documento")
    void deberiaActualizarDocumento() throws Exception {

        String documentoActualizado = """
            {
                "nombreDocumento": "Documento actualizado",
                "activo": true
            }
            """;

        mockMvc.perform(
                        put("/documento/actualizar/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(documentoActualizado)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDocumento")
                        .value("Documento actualizado"));
    }

    // DELETE
    @Test
    @DisplayName("🔴 DELETE: Debería eliminar documento")
    void deberiaEliminarDocumento() throws Exception {

        mockMvc.perform(
                        delete("/documento/eliminar/1")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idEliminado")
                        .value(1));
    }
}