package lk.ijse.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    int id;

    @Column(name = "order_details")
    private String description;

    @CreationTimestamp
    @Column(name = "order_date_time")
    private Timestamp order_data_time;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

//    @ManyToMany(cascade = CascadeType.ALL,fetch =FetchType.LAZY)
//    private List<Item> items = new ArrayList<>();

    //Fetch meaning retrieve or get

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "order")
    private List<OrderDetail> orderDetailsList = new ArrayList<>();


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", order_data_time=" + order_data_time +
//                ", customer=" + customer +
//                ", orderDetailsList=" + orderDetailsList +
                '}';
    }
}

