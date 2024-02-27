package lk.ijse;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransientPersistentDetachedState {

    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance().getSession();

        //Transient State
        Customer customer = new Customer();
        customer.setName("Kasun");
        customer.setAddress("Galle");


        boolean isContains = session.contains(customer);
        if (isContains){
            System.out.println("This Object is Not Transient");
        }else {
            System.out.println("This Object is in Transient State");
        }


        //Persistent State

        Transaction transaction = session.beginTransaction();
        int customerId = (int) session.save(customer);
        transaction.commit();
        System.out.println(customerId);

        boolean  isPersistence = session.contains(customer);
        if (isPersistence) {
            System.out.println("Customer is in the Persistent State");
        } else {
            System.out.println("Customer is in the Transient State");
        }
        session.close();



        //Detached State
        Session detachSession = SessionFactoryConfig.getInstance().getSession();
        detachSession.detach(customer);

        boolean isPersists = detachSession.contains(customer);

        if (isPersists) {
            System.out.println("Customer is in the Persistent State");
        } else {
            System.out.println("Customer is in the Detached State");
        }


        //Return to Persistent State
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

