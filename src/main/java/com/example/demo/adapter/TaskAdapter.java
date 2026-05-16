package com.example.demo.adapter;

import com.example.demo.model.Task;
import com.example.demo.entity.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskAdapter {

    // Convierte de Entity a Model
    public Task toModel(TaskEntity entity) {
        if (entity == null) {
            return null;
        }

        Task task = new Task();
        task.setTitulo(entity. getTitulo());
        task.setFechaCreacion(entity.getFechaCreacion());
        // Si Task tuviera más campos, los mapearías aquí

        return task;
    }

    // Convierte de Model a Entity
    public TaskEntity toEntity(Task model) {
        if (model == null) {
            return null;
        }

        TaskEntity entity = new TaskEntity();
        entity.setTitulo(model.getTitulo());
        entity.setFechaCreacion(model.getFechaCreacion());
        // Si TaskEntity tuviera más campos, los mapearías aquí

        return entity;
    }
}
