package entity;


import embeddad.NameIdentifier;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table (name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id")
    private int id;

    @Column(name = "customer_name")
    private NameIdentifier name;

    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_salary")
    private double salary;

    @Column(name = "customer_number")
    private int mobileNum;

    @CreationTimestamp
    private Timestamp timestamp;

    public Customer() {
    }

    public Customer(int id, NameIdentifier name, String address, double salary, int mobileNum, Timestamp timestamp) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.mobileNum = mobileNum;
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

    public int getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(int mobileNum) {
        this.mobileNum = mobileNum;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name=" + name +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", mobileNum=" + mobileNum +
                ", timestamp=" + timestamp +
                '}';
    }
}

