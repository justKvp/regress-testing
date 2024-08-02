package ru.example.framework.postgres.dbmgr;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.example.framework.postgres.models.User;

@Singleton
public class DBMgr {
    private static final Logger logger = LoggerFactory.getLogger("DBMgr");

    @Getter
    private static SessionFactory sessionFactory;

    private static StandardServiceRegistry registry;

    public static void initialize(String configFileName) {
        loadConfigFile("databases/" + configFileName);
        createSessionFactory();
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
        logger.info("factory has been successfully closed");
    }

    public static Session createSession() {
        return sessionFactory.openSession();
    }

    public static void closeSession(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public static EntityManager createEntityManager() {
        return sessionFactory.createEntityManager();
    }

    private static void loadConfigFile(String configFileName) {
        registry =
                new StandardServiceRegistryBuilder()
                        .configure(configFileName)
                        .build();
    }

    private static void createSessionFactory() {
        try {
            sessionFactory =
                    new MetadataSources(registry)
                            .addAnnotatedClass(User.class)
                            .buildMetadata()
                            .buildSessionFactory();
            logger.info("has been initialized successfully");
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we
            // had trouble building the SessionFactory so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
            logger.info("has been initialize failed: " + e.getMessage());
        }
    }
}
