package com.hack.vendorinventory.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "order")
public class OrderImpl implements Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", updatable = false, nullable = false)
    private Long orderId;

    @Column(name = "item_detail_id")
    private Long itemDetailsId;

    @Column(name = "item_order_quantity")
    private Double itemOrderQuantity;

    @Column(name = "order_time")
    private Timestamp orderTime;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getItemDetailsId() {
        return itemDetailsId;
    }

    public void setItemDetailsId(Long itemDetailsId) {
        this.itemDetailsId = itemDetailsId;
    }

    public Double getItemOrderQuantity() {
        return itemOrderQuantity;
    }

    public void setItemOrderQuantity(Double itemOrderQuantity) {
        this.itemOrderQuantity = itemOrderQuantity;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }
}
