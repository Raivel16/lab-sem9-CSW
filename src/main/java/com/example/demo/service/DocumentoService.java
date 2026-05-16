package com.example.demo.service;

import com.example.demo.adapter.DocumentoAdapter;
import com.example.demo.entity.DocumentoEntity;
import com.example.demo.model.Documento;
import com.example.demo.repository.DocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
//         DocumentoEntity entity = documentoAdapter.toEntity(documento); //F3
//         DocumentoEntity savedEntity = documentoRepository.save(entity); //F3
//         return documentoAdapter.toModel(savedEntity); //F3

        Documento doc_resp = new Documento(); // F1 Y F2
//        doc_resp.setNombreDocumento(documento.getNombreDocumento()); //F2
        return doc_resp; // F1 Y F2
    }

    // Listar
    public List<Documento> listarDocumentos() {
//         List<DocumentoEntity> entities = documentoRepository.findAll(); // F3
//
//         return entities.stream().map( e -> documentoAdapter.toModel(e)).collect(Collectors.toList()); // F3

//        List<Documento> lista = new ArrayList<>(); // F2
//
//        lista.add(new Documento()); // F2
//        lista.add(new Documento()); // F2
//        lista.add(new Documento()); // F2
//        lista.add(new Documento()); // F2
//        lista.add(new Documento()); // F2
//
//      return lista; // F2

         return new ArrayList<>(); // F1

    }

    // Actualizar
    public Documento actualizarDocumento(Long id, Documento documento) {
//         DocumentoEntity entityExistente = documentoRepository.findById(id).orElse(null); // F3
//
//         if (entityExistente == null) { return null; } // F3
//
//         entityExistente.setNombreDocumento(documento.getNombreDocumento()); // F3
//         entityExistente.setActivo(documento.isActivo()); // F3
//         DocumentoEntity entityActualizada = documentoRepository.save(entityExistente); // F3
//         return documentoAdapter.toModel(entityActualizada); // F3

        Documento docActualizado = new Documento(); // F1 y F2
//        docActualizado.setNombreDocumento("Documento actualizado"); // F2
        return docActualizado; // F1 y F2
    }

    // Eliminar
    public Long eliminarDocumento(Long id) {
//        DocumentoEntity entity =
//                documentoRepository.findById(id).orElse(null); // F3
//
//        if(entity == null){ // F3
//            return null; // F3
//        } // F3
//
//        documentoRepository.delete(entity); // F3
//        return entity.getIdDocumento(); //F3


//        return id; // F2

         return -1L; // F1
    }
}