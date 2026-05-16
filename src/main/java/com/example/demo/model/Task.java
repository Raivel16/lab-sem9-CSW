package com.example.demo.model;

import java.time.LocalDate;

public class Task {

    private String titulo;
    private LocalDate fechaCreacion;

    public Task(String titulo, LocalDate fechaCreacion) {
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
    }

    public Task() {
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
