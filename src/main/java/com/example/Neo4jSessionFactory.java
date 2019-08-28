package com.example;

import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

public class Neo4jSessionFactory {

    private static ClasspathConfigurationSource configurationSource =
            new ClasspathConfigurationSource("ogm.properties");

    private static Configuration configuration = new Configuration.Builder(configurationSource).build();

    private static SessionFactory sessionFactory = new SessionFactory(configuration, "com.example.domai");

    private static Neo4jSessionFactory factory = new Neo4jSessionFactory();


    private Neo4jSessionFactory() {
    }

    public static Neo4jSessionFactory getInstance() {
        return factory;
    }

    public Session getNeo4jSession() {
        return sessionFactory.openSession();
    }
}
