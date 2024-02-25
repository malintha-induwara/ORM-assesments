package lk.ijse;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransientState {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("Kasun");
        customer.setAddress("Galle");
        //Save Customer
//
//        Session session = SessionFactoryConfig.getInstance().getSession();
//
//        session.beginTransaction();
//

//        boolean contains = session.contains(customer);
//
//        if (contains) {
//            System.out.println("Customer is in the Persistent State");
//        } else {
//            System.out.println("Customer is in the Transient State");
//        }


        //Persistent State

        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        int customerId = (int) session.save(customer);


        transaction.commit();

        System.out.println("Cust Id:"+customerId);

        boolean isPersistent = session.contains(customer);

        if (isPersistent) {
            System.out.println("Customer is in the Persistent State");
        } else {
            System.out.println("Customer is in the Transient State");
        }


    }
}

