package lk.ijse;

import lk.ijse.entity.Customer;
import lk.ijse.entity.Order;
import lk.ijse.projection.CustomerProjection;
import lk.ijse.repository.CustomerRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {



        //Save Customer
//        CustomerRepository  repo= new CustomerRepository();
//        repo.saveCustomer(getCustomer());


//        //Get Customer
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


//        CustomerRepository customerRepository = new CustomerRepository();
//        List<Order> ordersByCustomerId = customerRepository.getOrdersByCustomerId(1);


//        for (Order order:ordersByCustomerId){
//            System.out.println(order);
//        }

//        CustomerRepository customerRepository = new CustomerRepository();
//        List<Customer> customerHQL = customerRepository.getCustomerHQL();
//
//       for (Customer customer:customerHQL){
//           System.out.println(customer);
//       }

        CustomerRepository customerRepository = new CustomerRepository();
        List<CustomerProjection> customerProjection = customerRepository.getCustomerProjection();

        customerProjection.forEach(System.out::println);


    }


    public static Customer getCustomer(){
        Customer customer = new Customer();
        customer.setName("Kasun");
        customer.setAddress("Galle");
        return customer;
    }



}