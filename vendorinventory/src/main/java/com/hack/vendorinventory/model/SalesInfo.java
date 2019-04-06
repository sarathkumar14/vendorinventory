package com.hack.vendorinventory.model;

import java.math.BigDecimal;

public interface SalesInfo {

    String getProductName();

    void setProductName(String productName);

    Integer getCategoryId();

    void setCategoryId(Integer categoryId);

    Integer getProductQuantity();

    void setProductQuantity(Integer productQuantity);

    BigDecimal getProductRate();

    void setProductRate(BigDecimal productRate);

    Long getSalesInfoId();

    void setSalesInfoId(Long salesInfoId);

    String getOrganizationName();

    void setOrganizationName(String organizationName);

}
