package entity;


import embeddad.MobileNo;
import embeddad.NameIdentifier;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "customer_name")
    private NameIdentifier name;

    //You can define columns using following attributes as well
    @Column(name = "customer_address" , length = 100 ,nullable = false)
    private String address;

    @Column(name = "customer_salary")
    private double salary;


    @ElementCollection
    @CollectionTable(name = "customer_mobile_no",
    joinColumns = @JoinColumn(name = "customer_id"))
    private List<MobileNo> mobileNos = new ArrayList<>();

    @CreationTimestamp
    private Timestamp timestamp;

    public Customer() {
    }

    public Customer(int id, NameIdentifier name, String address, double salary, List<MobileNo> mobileNos, Timestamp timestamp) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.mobileNos = mobileNos;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NameIdentifier getName() {
        return name;
    }

    public void setName(NameIdentifier name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<MobileNo> getMobileNos() {
        return mobileNos;
    }

    public void setMobileNos(List<MobileNo> mobileNos) {
        this.mobileNos = mobileNos;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}

