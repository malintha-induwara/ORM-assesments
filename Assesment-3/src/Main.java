import config.SessionFactoryConfig;
import embeddad.NameIdentifier;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        //Save
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setAddress("Galle");
        customer.setSalary(30000);

        NameIdentifier nameIdentifier = new NameIdentifier("Saman","Kumara","Hello");
        customer.setName(nameIdentifier);



        session.save(customer);
        transaction.commit();
        session.close();

        //Exists
//        Session session = SessionFactoryConfig.getInstance().getSession();
//        Customer exist = session.get(Customer.class,2);
//        System.out.println(exist);
//        session.close();



        //Update
//        Session session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        Customer existCustomer =session.get(Customer.class,2);
//        existCustomer.setAddress("Galle");
//        session.update(existCustomer);
//        transaction.commit();
//        session.close();


        //Delete
//        Session deleteSession = SessionFactoryConfig.getInstance().getSession();
//        Transaction deleteTransaction = deleteSession.beginTransaction();
//        Customer deleteCustomer = deleteSession.get(Customer.class, 3);
//        deleteSession.delete(deleteCustomer);
//        deleteTransaction.commit();
//        deleteSession.close();


    }
}