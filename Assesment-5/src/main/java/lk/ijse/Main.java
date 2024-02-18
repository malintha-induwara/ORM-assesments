package lk.ijse;

import lk.ijse.entity.Customer;
import lk.ijse.repository.CustomerRepository;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setName("Saman");
        customer.setAddress("Galle");

        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.saveCustomer(customer);
//
//        CustomerRepository customerRepository1 = new CustomerRepository();
//        Customer customer1 = customerRepository1.getCustomer(1);


    }
}