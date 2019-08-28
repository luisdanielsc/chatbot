package com.example.service;

import com.example.Neo4jSessionFactory;
import com.example.domain.Entity;
import org.neo4j.ogm.session.Session;

import java.util.stream.Stream;

public abstract class GenericService<T extends Entity> implements Service<T> {

    private static final int DEPTH_LIST = 0;

    private static final int DEPTH_ENTITY = 1;

    private Session session = Neo4jSessionFactory.getInstance().getNeo4jSession();

    @Override
    public Stream<T> findAll() {
        return session.loadAll(getEntityType(), DEPTH_LIST).stream();
    }

    @Override
    public T find(Long id) {
        return session.load(getEntityType(), id);
    }

    @Override
    public void delete(Long id) {
        session.delete(id);
    }

    @Override
    public T CreateOrUpdate(T entity) {
        session.save(entity, DEPTH_ENTITY);
        return find(entity.getId());
    }

    abstract Class<T> getEntityType();
}
