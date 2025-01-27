package com.example.domain;

import com.example.data.Task;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\f"}, d2 = {"Lcom/example/domain/TaskRepository;", "", "createTask", "Lcom/example/data/Task;", "task", "deleteTask", "", "id", "", "getAllTasks", "", "updateTask", "todolist-ktor-latest"})
public abstract interface TaskRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.data.Task> getAllTasks();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.data.Task createTask(@org.jetbrains.annotations.NotNull()
    com.example.data.Task task);
    
    public abstract boolean deleteTask(long id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.data.Task updateTask(long id, @org.jetbrains.annotations.NotNull()
    com.example.data.Task task);
}