package lk.ijse.entity;

import javax.persistence.*;


@Entity(name = "order_details")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailPK orderDetailPK;

    @Column(name = "order_qty")
    private int orderQty;

    @Column(name = "order_price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id",insertable = false,updatable = false)
    private Order order;


    @ManyToOne
    @JoinColumn(name = "item_id",referencedColumnName = "item_id",insertable = false,updatable = false)
    private Item item;

}


