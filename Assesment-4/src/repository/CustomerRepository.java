package repository;

import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerRepository {

    private final Session session;


    public CustomerRepository() {
        session = SessionFactoryConfig.getInstance().getSession();
    }


    public int saveCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        try {
            int customerId = (int) session.save(customer);
            transaction.commit();
            return customerId;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return -1;
        }finally {
            session.close();
        }
    }


    public Customer getCustomer(int id) {
        try {
            Customer customer = session.get(Customer.class, id);
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }


    public boolean updateCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try{
            session.update(customer);
            transaction.commit();
            return true;
        }catch (Exception e){
            return false;
        }finally {
            session.close();
        }
    }


    public boolean deleteCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(customer);
            transaction.commit();
            return true;
        }catch (Exception e){
            return false;
        }finally {
            session.close();
        }

    }


}

