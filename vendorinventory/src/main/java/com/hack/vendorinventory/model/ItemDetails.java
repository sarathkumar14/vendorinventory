package com.hack.vendorinventory.model;

public interface ItemDetails {

    Long getItemDetailId();

    void setItemDetailId(Long itemDetailId);

    String getItemName();

    void setItemName(String itemName);

    Double getRequiredQuantity();

    void setRequiredQuantity(Double requiredQuantity);

    Integer getCategoryId();

    void setCategoryId(Integer categoryId);

    Double getItemThreshold();

    void setItemThreshold(Double itemThreshold);

    Double getCurrentShelfQuantity();

    void setCurrentShelfQuantity(Double currentShelfQuantity);

    Long getProductDetailsId();

    void setProductDetailsId(Long productDetailsId);

    String getProductName();

    void setProductName(String productName);

    Double getOrderValue();

    void setOrderValue(Double orderValue);

    String getOrganizationName();

    void setOrganizationName(String organizationName);

}
