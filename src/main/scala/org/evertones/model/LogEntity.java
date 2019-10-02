package org.evertones.model;

import java.util.Set;

public abstract class LogEntity<T extends Model> {

    private final T entity;

    private final Set<LogData> data;

    public LogEntity(T entity, Set<LogData> data) {
        this.entity = entity;
        this.data = data;
    }

    public T getEntity() {
        return entity;
    }

    public Set<LogData> getData() {
        return data;
    }
}
