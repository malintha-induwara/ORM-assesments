package lk.ijse.config;

import lk.ijse.entity.Customer;
import lk.ijse.entity.Item;
import lk.ijse.entity.Order;
import lk.ijse.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

    private static SessionFactoryConfig sessionFactoryConfig;

    private final SessionFactory sessionFactory;


    // 1. creates a service registry
        /*StandardServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                .configure()
                .build();*/

    // 2. creates a Metadata object
        /*Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .build();*/


    // 3. create a Session Factory
        /*sessionFactory = metadata
                .buildSessionFactory();*/

    //Shorten the above code
        /*sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder()
                .configure()
                .build())
                .addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .build()
                .buildSessionFactory();*/

    //using configuration object

    private SessionFactoryConfig(){
        this.sessionFactory= new Configuration().configure().addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(OrderDetail.class).buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance(){
        return (sessionFactoryConfig==null)?sessionFactoryConfig=new SessionFactoryConfig():sessionFactoryConfig;
    }

    public Session getSession(){
        return this.sessionFactory.openSession();
    }



}

