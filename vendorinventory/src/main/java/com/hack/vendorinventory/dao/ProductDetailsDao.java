package com.hack.vendorinventory.dao;

import com.hack.vendorinventory.model.ItemDetails;
import com.hack.vendorinventory.model.ProductDetails;
import com.hack.vendorinventory.model.SalesInfo;

import java.util.List;

public interface ProductDetailsDao {

    List<ItemDetails> getItemDetailsList();

    List<ItemDetails> getItemDetailsList(Long productId);

    List<ItemDetails> getItemDetailsListByProductName(String productName);

    List<ItemDetails> getItemDetailsList(String organizationName);

    List<ProductDetails> getProductDetailsList(String organizationName);

    ProductDetails saveProductDetails(ProductDetails productDetails);

    ProductDetails getProductDetailsByName(String productName);

    ItemDetails saveItemDetails(ItemDetails itemDetails);

    SalesInfo saveSalesInfo(SalesInfo salesInfo);

    ItemDetails getItemDetailsByItemDetailId(Long itemDetailId);

    List<String> getProductNameList();
}
