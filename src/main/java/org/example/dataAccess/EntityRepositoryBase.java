package org.example.dataAccess;

import org.example.entities.Entity;

import java.util.List;

public class EntityRepositoryBase<TEntity extends BaseEntity> implements EntityRepository<TEntity> {

    @Override
    public void insert(TEntity entity) {

    }

    @Override
    public void delete(TEntity entity) {
        System.out.println("Entity deleted: " + entity);
    }

    @Override
    public void update(TEntity entity) {
        System.out.println("Entity updated: " + entity);
    }

    @Override
    public TEntity getById(int id) {
        return null;
    }

    @Override
    public List<TEntity> getAll() {
        return List.of();
    }
}
