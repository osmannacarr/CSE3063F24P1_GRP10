package org.example.dataAccess;

import org.example.entities.Entity;

import java.util.List;

public interface EntityRepository<T extends BaseEntity> {
    // Crud operations
    void insert(T entity);

    void delete(T entity);

    void update(T entity);

    T getById(int id);

    List<T> getAll();
}
