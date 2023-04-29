package com.example.demo1.Util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class ConfigureDataSource {
    public static EntityManagerFactory getEntityManager(){
        System.out.println("Initiating entitymanager");
        Map<String, Object> property = new HashMap<>();
        property.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        property.put("hibernate.show_sql", "true");
        property.put("hibernate.globally_quoted_identifiers", "true");
        property.put("hibernate.globally_quoted_identifiers_skip_column_definitions", "true");
        property.put("hibernate.use_sql_comments", "true");
        property.put("hibernate.format_sql", "true");
        property.put("javax.persistence.query.timeout", "60000");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Postgres_DB");
        Map<String, Object> properties = emf.getProperties();
        if (properties.isEmpty()) {

            System.out.println("No properties set");

        } else {
            for (Map.Entry<String, Object> entry : properties.entrySet()) {

                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        return emf;
    }
}
