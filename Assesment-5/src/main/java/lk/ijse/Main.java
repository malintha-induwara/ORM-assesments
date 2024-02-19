package lk.ijse;

import lk.ijse.entity.Customer;
import lk.ijse.repository.CustomerRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {



        //Save Customer
//        CustomerRepository  repo= new CustomerRepository();
//        repo.saveCustomer(getCustomer());


        //Get Customer
//        CustomerRepository  repo = new CustomerRepository();
//        Customer customer = repo.getCustomer(1);
//        System.out.println(customer);
//

        //SQL Query
//        CustomerRepository  repo= new CustomerRepository();
//        repo.getAllCustomerSQL();


        //JPQL Query
//        CustomerRepository  repo= new CustomerRepository();
//        List<Customer> allCustomerJPQL = repo.getAllCustomerJPQL();
//        allCustomerJPQL.forEach(System.out::println);


    }


    public static Customer getCustomer(){
        Customer customer = new Customer();
        customer.setName("Kasun");
        customer.setAddress("Galle");
        return customer;
    }



}