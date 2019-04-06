package com.hack.vendorinventory.model;


import javax.persistence.*;

@Entity
@Table(name = "product_details")
public class ProductDetailsImpl implements ProductDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_detail_id", updatable = false, nullable = false)
    private Long productDetailId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "organization_id")
    private Long organizationId;

    public Long getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Long productDetailId) {
        this.productDetailId = productDetailId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
