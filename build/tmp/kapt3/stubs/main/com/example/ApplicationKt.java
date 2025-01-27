package com.example;

import io.ktor.server.engine.*;
import io.ktor.server.netty.*;
import io.ktor.server.application.*;
import io.ktor.server.plugins.contentnegotiation.*;
import io.ktor.serialization.gson.*;
import com.example.domain.TaskRepositoryImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0005\u00a8\u0006\u0006"}, d2 = {"main", "", "provideDataSource", "Ljavax/sql/DataSource;", "module", "Lio/ktor/server/application/Application;", "todolist-ktor-latest"})
public final class ApplicationKt {
    
    public static final void main() {
    }
    
    public static final void module(@org.jetbrains.annotations.NotNull()
    io.ktor.server.application.Application $this$module) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final javax.sql.DataSource provideDataSource() {
        return null;
    }
}