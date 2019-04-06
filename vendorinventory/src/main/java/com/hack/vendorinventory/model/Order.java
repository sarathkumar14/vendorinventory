package com.hack.vendorinventory.model;

import java.sql.Timestamp;

public interface Order {

    Long getOrderId();

    void setOrderId(Long orderId);

    Long getItemDetailsId();

    void setItemDetailsId(Long itemDetailsId);

    Double getItemOrderQuantity();

    void setItemOrderQuantity(Double itemOrderQuantity);

    Timestamp getOrderTime();

    void setOrderTime(Timestamp orderTime);

}
