package lk.ijse;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DetachedState {

    public static void main(String[] args) {


        Customer customer = new Customer();
        customer.setName("Kasun");
        customer.setAddress("Galle");

        //Persistent State
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        int customerId = (int) session.save(customer);


        boolean isContains = session.contains(customer);
        if (isContains) {
            System.out.println("Customer is in the Persistent State");
        } else {
            System.out.println("Customer is in the Transient State");
        }

        transaction.commit();
        session.close();


        //

        //Detached State
        Session detachSession = SessionFactoryConfig.getInstance().getSession();
        detachSession.detach(customer);

        boolean isPersists = detachSession.contains(customer);

        if (isPersists) {
            System.out.println("Customer is in the Persistent State");
        } else {
            System.out.println("Customer is in the Detached State");
        }


        //Persistent State
        customer.setAddress("Matara");
        detachSession.save(customer);


        boolean contains = detachSession.contains(customer);
        if (contains) {
            System.out.println("Customer is in the Persistent State");
        } else {
            System.out.println("Customer is in the Transient State");
        }


        detachSession.close();

    }
}

