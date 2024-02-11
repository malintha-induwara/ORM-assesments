package lk.ijse.config;

import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class SessionFactoryConfig {

    private static SessionFactoryConfig sessionFactoryConfig;

    private final SessionFactory sessionFactory;


    //This is the Official Hibernate documentation implementation using maven
    private SessionFactoryConfig(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).addAnnotatedClass(Customer.class).buildMetadata().buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance(){
        return (sessionFactoryConfig==null)?sessionFactoryConfig=new SessionFactoryConfig():sessionFactoryConfig;
    }

    public Session getSession(){
        return this.sessionFactory.openSession();
    }

}

