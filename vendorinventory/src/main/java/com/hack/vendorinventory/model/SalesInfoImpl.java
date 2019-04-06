package com.hack.vendorinventory.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sales_info")
public class SalesInfoImpl implements SalesInfo{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long salesInfoId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "product_quantity")
    private Integer productQuantity;

    @Column(name = "product_rate")
    private BigDecimal productRate;

    public Long getSalesInfoId() {
        return salesInfoId;
    }

    public void setSalesInfoId(Long salesInfoId) {
        this.salesInfoId = salesInfoId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public BigDecimal getProductRate() {
        return productRate;
    }

    public void setProductRate(BigDecimal productRate) {
        this.productRate = productRate;
    }
}
