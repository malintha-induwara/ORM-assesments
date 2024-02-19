package lk.ijse.embedded;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Embeddable
public class OrderDetailPK implements Serializable {

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "item_id")
    private int itemId;
}

