import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class
Main {
    public static void main(String[] args) {

        Session session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction =session.beginTransaction();

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setSalary(25000);

        session.save(customer);
        transaction.commit();
        session.close();
    }
}