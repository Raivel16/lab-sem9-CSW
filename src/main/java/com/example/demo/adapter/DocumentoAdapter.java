package com.example.demo.adapter;

import com.example.demo.entity.DocumentoEntity;
import com.example.demo.model.Documento;
import org.springframework.stereotype.Component;

@Component
public class DocumentoAdapter {

    // Convierte de Entity a Model
    public Documento toModel(DocumentoEntity entity) {
        if (entity == null) {
            return null;
        }

        Documento documento = new Documento();
        documento.setIdDocumento(entity.getIdDocumento());
        documento.setNombreDocumento(entity.getNombreDocumento());
        documento.setActivo(entity.isActivo());

        return documento;
    }

    // Convierte de Model a Entity
    public DocumentoEntity toEntity(Documento model) {
        if (model == null) {
            return null;
        }

        DocumentoEntity entity = new DocumentoEntity();
        entity.setIdDocumento(model.getIdDocumento());
        entity.setNombreDocumento(model.getNombreDocumento());
        entity.setActivo(model.isActivo());

        return entity;
    }
}