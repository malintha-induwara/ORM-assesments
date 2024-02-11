package lk.ijse;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        //Save
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer(1,"Saman","Panadura",50000,12345678);
        session.persist(customer);
        transaction.commit();
        session.close();

    }
}