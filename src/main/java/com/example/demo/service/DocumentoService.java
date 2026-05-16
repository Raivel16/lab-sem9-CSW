package com.example.demo.service;

import com.example.demo.adapter.DocumentoAdapter;
import com.example.demo.entity.DocumentoEntity;
import com.example.demo.model.Documento;
import com.example.demo.repository.DocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoService {

    private DocumentoRepository documentoRepository;
    private DocumentoAdapter documentoAdapter;

    public DocumentoService(DocumentoRepository documentoRepository,
                            DocumentoAdapter documentoAdapter) {
        this.documentoRepository = documentoRepository;
        this.documentoAdapter = documentoAdapter;
    }

    // Crear
    public Documento guardarDocumento(Documento documento) {


        return null;
    }

    // Listar
    public List<Documento> listarDocumentos() {


        return null;
    }

    // Actualizar
    public Documento actualizarDocumento(Long id, Documento documento) {

    }

    // Eliminar
    public void eliminarDocumento(Long id) {

    }
}