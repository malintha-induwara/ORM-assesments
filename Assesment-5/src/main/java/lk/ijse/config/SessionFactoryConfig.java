package lk.ijse.config;

import lk.ijse.entity.Customer;
import lk.ijse.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

    private static SessionFactoryConfig sessionFactoryConfig;

    private final SessionFactory sessionFactory;


    private SessionFactoryConfig(){
        this.sessionFactory= new Configuration().configure().addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class).buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance(){
        return (sessionFactoryConfig==null)?sessionFactoryConfig=new SessionFactoryConfig():sessionFactoryConfig;
    }

    public Session getSession(){
        return this.sessionFactory.openSession();
    }



}

