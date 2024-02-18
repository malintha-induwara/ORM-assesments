import config.SessionFactoryConfig;
import embeddad.MobileNo;
import embeddad.NameIdentifier;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


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
        NameIdentifier nameIdentifier = new NameIdentifier("Saman", "Kumara", "Hello");
        customer.setName(nameIdentifier);

        CustomerRepository customerRepository = new CustomerRepository();
        Customer custom = customerRepository.getCustomer( 1);


        customerRepository = new CustomerRepository();
        customerRepository.updateCustomer(custom);




    }

    private static void save(Customer customer) {
        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.saveCustomer(customer);
    }

    public static Customer get() {
        //Check whether the customer id 2 on the table or not
        CustomerRepository customerRepository = new CustomerRepository();
        Customer exist = customerRepository.getCustomer( 1);
        return exist;
    }

    public static void update(Customer customer) {
        //Update the customer details
        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.updateCustomer(customer);
    }


    public static void delete(Customer customer) {
        //Delete customer
      CustomerRepository customerRepository = new CustomerRepository();
      customerRepository.deleteCustomer(customer);
    }


}