package lk.ijse.entity;//package entity;
//
//import embedded.MobileNumber;
//import embedded.NameIdentifier;
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
////@Entity(name = "customer")
//@Entity
//@Table(name = "customer")
public class CustomerOld {
//
//    @Id //tells hibernate that this is the primary key of this table
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "customer_id")
//    private int id;
//    @Column(name = "customer_name")
//    private NameIdentifier name;
//    @Column(name = "customer_address", length = 100, nullable = false)
//    private String address;
//    @Transient //doesn't create table in hibernate
//    @Column(name = "customer_salary")
//    private double salary;
//    @CreationTimestamp
//    private Timestamp createdDateTime;
//    @ElementCollection //use when there is multiple values
//    @CollectionTable(
//            name = "customer_mobile_nos",
//            joinColumns = @JoinColumn(name = "customer_id"))
//    private List<MobileNumber> mobileNumbers = new ArrayList<>();
//
//    @Transient
//    @Column(name = "customer_age")
//    private int age;
}
