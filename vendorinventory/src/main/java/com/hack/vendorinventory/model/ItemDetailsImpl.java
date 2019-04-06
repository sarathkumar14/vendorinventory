package com.hack.vendorinventory.model;


import javax.persistence.*;

@Entity
@Table(name = "item_details")
public class ItemDetailsImpl implements ItemDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_detail_id", updatable = false, nullable = false)
    private Long itemDetailId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "required_quantity")
    private Double requiredQuantity;

    @Column(name = "order_vaue")
    private Double orderValue;

    @Column(name = "item_threshold")
    private Double itemThreshold;

    @Column(name = "shelf_quantity")
    private Double currentShelfQuantity;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "product_details_id")
    private Long productDetailsId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "organization_name")
    private String organizationName;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Long getItemDetailId() {
        return itemDetailId;
    }

    public void setItemDetailId(Long itemDetailId) {
        this.itemDetailId = itemDetailId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(Double requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Double orderValue) {
        this.orderValue = orderValue;
    }

    public Double getItemThreshold() {
        return itemThreshold;
    }

    public void setItemThreshold(Double itemThreshold) {
        this.itemThreshold = itemThreshold;
    }

    public Double getCurrentShelfQuantity() {
        return currentShelfQuantity;
    }

    public void setCurrentShelfQuantity(Double currentShelfQuantity) {
        this.currentShelfQuantity = currentShelfQuantity;
    }

    public Long getProductDetailsId() {
        return productDetailsId;
    }

    public void setProductDetailsId(Long productDetailsId) {
        this.productDetailsId = productDetailsId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
