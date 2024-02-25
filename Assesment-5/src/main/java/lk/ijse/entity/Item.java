package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

@Entity
@Table(name = "item")
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_qty")
    private int qty;

    @Column(name = "unit_prce")
    private double unitPrice;

//    @ManyToMany(mappedBy = "items")
//    private List<Order> orders = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY ,mappedBy = "item")
    private List<OrderDetail> orderDetails = new ArrayList<>();


}

