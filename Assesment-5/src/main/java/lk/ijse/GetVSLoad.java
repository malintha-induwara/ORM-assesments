package lk.ijse;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Customer;
import org.hibernate.Session;

public class GetVSLoad {

    public static void main(String[] args) {


        //1. Get
        Session getSession = SessionFactoryConfig.getInstance().getSession();
        System.out.println("--------------Get----------------");
        Customer getCus = getSession.get(Customer.class, 1);

        System.out.println("Customer Id of Get: " + getCus.getId());
        System.out.println("Customer Name of Get:" + getCus.getName());


        //2.load
        Session loadSession = SessionFactoryConfig.getInstance().getSession();
        System.out.println("--------------Get----------------");
        Customer loadCus = loadSession.load(Customer.class, 2);

        System.out.println("Customer Id of Get: " + loadCus.getId());
        System.out.println("Customer Name of Get:" + loadCus.getName());

        loadSession.close();


    }
}

