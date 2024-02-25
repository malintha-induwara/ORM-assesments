package lk.ijse;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RemovedState {
    public static void main(String[] args) {


        Session session = SessionFactoryConfig.getInstance().getSession();

        Customer customer = session.get(Customer.class, 1);
        boolean contains = session.contains(customer);
        extracted(contains);




        Transaction transaction = session.beginTransaction();
        session.delete(customer);
        transaction.commit();

        boolean isContains = session.contains(customer);
        extracted(isContains);

        session.close();

    }

    private static void extracted(boolean isContains) {

        if (isContains) {
            System.out.println("Customer is in the Persistent State");
        } else {
            System.out.println("Customer is in the Delete State");
        }

    }
}

