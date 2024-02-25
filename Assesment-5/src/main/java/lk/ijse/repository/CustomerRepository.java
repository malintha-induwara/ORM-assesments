package lk.ijse.repository;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Order;
import lk.ijse.projection.CustomerProjection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

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
            transaction.rollback();
            e.printStackTrace();
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
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }

    }


    public List<Object []> getAllCustomerSQL(){
        String sql = "SELECT * FROM customer";
        NativeQuery query = session.createNativeQuery(sql);
        List<Object []> list= query.list();

        for (Object customer:list){
            System.out.println(customer);
        }

        // So if you are trying to get the details use following lines to convert into customer list
//        NativeQuery<Customer> query = session.createNativeQuery(sql, Customer.class);
//        List<Customer> list = query.list();

        session.close();
        return list;
    }



    public List<Customer> getAllCustomerJPQL(){
        String sql = "SELECT C FROM Customer AS C";
        Query query = session.createQuery(sql);
        List<Customer> list = query.list();
        session.close();
        return list;
    }


    public List<Order> getOrdersByCustomerId(int cusId){
        String sql = "SELECT O FROM Order As O\n" +
                "INNER JOIN Customer AS C ON O.customer.id=C.id\n" +
                " WHERE O.customer.id = :cus_id";

        Query query = session.createQuery(sql);
        query.setParameter("cus_id",cusId);
        List<Order> list = query.list();
        session.close();
        return list;

    }

    public List<Customer> getCustomerHQL(){
        String sql = "FROM Customer";
        Query query = session.createQuery(sql);
        List<Customer> customerList = query.list();
        session.close();
        return customerList;
    }

    public List<CustomerProjection> getCustomerProjection(){
        String sql = "SELECT new lk.ijse.projection.CustomerProjection(C.id,C.name) FROM Customer AS C";
        session.createQuery(sql);
        Query query = session.createQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }
}

