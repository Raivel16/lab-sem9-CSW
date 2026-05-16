package com.example.demo.service;

import com.example.demo.adapter.TaskAdapter;
import com.example.demo.entity.TaskEntity;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private TaskAdapter taskAdapter;

    public TaskService(TaskRepository taskRepository, TaskAdapter taskAdapter) {
        this.taskRepository = taskRepository;
        this.taskAdapter = taskAdapter;
    }

    public Task crearTarea(Task task) {
        TaskEntity entity = taskAdapter.toEntity(task); //F3
        TaskEntity savedEntity = taskRepository.save(entity); //F3
        return taskAdapter.toModel(savedEntity); //F3
//        Task task_resp = new Task();
//        task_resp.setTitulo(task.getTitulo()); //F2
//        return task_resp;
    }

    public List<Task> listarTareas() {
        List<TaskEntity> entities = taskRepository. findAll();

        // Convierte cada Entity a Model usando el adapter
        return entities.stream()
                .map( e -> taskAdapter.toModel(e) )
                .collect(Collectors.toList());
    }
}
