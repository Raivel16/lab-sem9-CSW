package com.example.demo.controller;

import com.example.demo.model.Documento;
import com.example.demo.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/documento")
public class DocumentoController {
    @Autowired
    private DocumentoService service;

    // Crear
    @PostMapping("/guardar")
    public Documento crear(@RequestBody Documento documento) {
        return service.guardarDocumento(documento);
    }

    // Listar todos
    @GetMapping("/listar")
    public List<Documento> listar() {
        return service.listarDocumentos();
    }

    // Actualizar
    @PutMapping("/actualizar/{id}")
    public Documento actualizar(@PathVariable Long id,
                                @RequestBody Documento documento) {
        return service.actualizarDocumento(id, documento);
    }

    // Eliminar
    @DeleteMapping("/eliminar/{id}")
    public Map<String, Long> eliminar(@PathVariable Long id) {

        Long idEliminado = service.eliminarDocumento(id);

        if(idEliminado == null){
            return Map.of(
                    "idEliminado", -1L
            );
        }

        return Map.of(
                "idEliminado", idEliminado
        );

    }
}