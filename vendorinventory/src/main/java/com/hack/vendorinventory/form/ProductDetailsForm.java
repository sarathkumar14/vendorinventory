package com.hack.vendorinventory.form;

import java.math.BigDecimal;

public class ProductDetailsForm {

    private String productName;

    private String itemName;

    private Long itemId;

    private Integer categoryId;

    private String organizationName;

    private Long organizationId;

    private Double requiredQuantity;

    private Integer productQuantity;

    private BigDecimal productRate;

    private Double currentShelValue;

    private Double itemThreshold;

    private Double orderValue;

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

    public Double getCurrentShelValue() {
        return currentShelValue;
    }

    public void setCurrentShelValue(Double currentShelValue) {
        this.currentShelValue = currentShelValue;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public Double getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(Double requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
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
