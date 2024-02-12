import config.SessionFactoryConfig;
import embeddad.MobileNo;
import embeddad.NameIdentifier;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Save

        //Get a session from the session factory
        Session session = SessionFactoryConfig.getInstance().getSession();


        //You have to start a transaction otherwise it's not going to save
        Transaction transaction = session.beginTransaction();

        //Create Customer object
        Customer customer = new Customer();

        //Set basic details
        customer.setId(1);
        customer.setAddress("Galle");
        customer.setSalary(30000);

        //If Customer has multivalued attributes define a class and create objects
        MobileNo dialog = new MobileNo("dialog", "0001");
        MobileNo mobiltel = new MobileNo("mobitel", "0002");
        MobileNo airtel = new MobileNo("airtel", "0003");

        //Add to array list because the customer object property accept an array list
        List<MobileNo> numList = new ArrayList<>();
        numList.add(dialog);
        numList.add(mobiltel);
        numList.add(airtel);

        //Set the array list
        customer.setMobileNos(numList);


        //If customer has composite attributes define another class
        NameIdentifier nameIdentifier = new NameIdentifier("Saman", "Kumara", "Hello");
        customer.setName(nameIdentifier);


        //Save
        //In later versions like 6.4.4 save method is deprecated so instead use session.persist()
        session.save(customer);
        transaction.commit();

        //Finally close the session
        session.close();

    }

    public static void exists() {
        //Check whether the customer id 2 on the table or not
        Session session = SessionFactoryConfig.getInstance().getSession();
        Customer exist = session.get(Customer.class, 1);
        System.out.println(exist);
        session.close();
    }

    public static void update() {
        //Update the customer details
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction updateTransaction = session.beginTransaction();
        Customer existCustomer = session.get(Customer.class, 1);
        existCustomer.setAddress("Galle");
        session.update(existCustomer);
        updateTransaction.commit();
        session.close();
    }


    public static void delete() {
        //Delete customer
        Session deleteSession = SessionFactoryConfig.getInstance().getSession();
        Transaction deleteTransaction = deleteSession.beginTransaction();
        Customer deleteCustomer = deleteSession.get(Customer.class, 1);
        deleteSession.delete(deleteCustomer);
        deleteTransaction.commit();
        deleteSession.close();
    }


}