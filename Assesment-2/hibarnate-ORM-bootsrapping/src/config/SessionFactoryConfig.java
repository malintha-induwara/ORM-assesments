package config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {
    private static SessionFactoryConfig sessionFactoryConfig;
    private SessionFactoryConfig(){
    }
    public static SessionFactoryConfig getInstance(){
        return (sessionFactoryConfig==null)?sessionFactoryConfig=new SessionFactoryConfig(): sessionFactoryConfig;
    }

    public Session getSession(){
        //1. Create a Service Registry
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

        //2. Create a Metadata Object
        Metadata metadata = new MetadataSources(serviceRegistry)
//                .addAnnotatedClass()
                .getMetadataBuilder().build();

        //3. Create a Session Factory
        SessionFactory sessionFactory = metadata.buildSessionFactory();

        //Create and Open the session
        return sessionFactory.openSession();
    }
}

