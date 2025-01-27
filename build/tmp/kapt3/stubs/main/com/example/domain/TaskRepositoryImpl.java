package com.example.domain;

import com.example.data.Task;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/domain/TaskRepositoryImpl;", "Lcom/example/domain/TaskRepository;", "dataSource", "Ljavax/sql/DataSource;", "(Ljavax/sql/DataSource;)V", "createTask", "Lcom/example/data/Task;", "task", "deleteTask", "", "id", "", "getAllTasks", "", "updateTask", "todolist-ktor-latest"})
public final class TaskRepositoryImpl implements com.example.domain.TaskRepository {
    @org.jetbrains.annotations.NotNull()
    private final javax.sql.DataSource dataSource = null;
    
    public TaskRepositoryImpl(@org.jetbrains.annotations.NotNull()
    javax.sql.DataSource dataSource) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.data.Task> getAllTasks() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.data.Task createTask(@org.jetbrains.annotations.NotNull()
    com.example.data.Task task) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.data.Task updateTask(long id, @org.jetbrains.annotations.NotNull()
    com.example.data.Task task) {
        return null;
    }
    
    @java.lang.Override()
    public boolean deleteTask(long id) {
        return false;
    }
}