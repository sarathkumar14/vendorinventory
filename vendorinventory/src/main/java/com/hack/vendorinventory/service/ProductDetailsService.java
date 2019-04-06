package com.hack.vendorinventory.service;

import com.hack.vendorinventory.form.ProductDetailsForm;
import com.hack.vendorinventory.model.ItemDetails;
import com.hack.vendorinventory.model.Order;
import com.hack.vendorinventory.model.ProductDetails;
import com.hack.vendorinventory.model.SalesInfo;
import org.json.JSONObject;

import java.util.List;

public interface ProductDetailsService {

    List<ItemDetails> getItemDetailsList();

    List<ItemDetails> getItemDetailsList(Long productId);

    List<ItemDetails> getItemDetailsList(String organizationName);

    List<ProductDetails> getProductDetailsList(String organizationName);

    ProductDetails saveProductDetails(ProductDetails productDetails);

    ItemDetails saveItemDetails(ItemDetails itemDetails);

    SalesInfo saveSalesInfo(SalesInfo salesInfo);

    ItemDetails getItemDetailsByItemDetailId(Long itemDetailId);

    JSONObject getProductDetails(ProductDetails productDetails);

    JSONObject getProductDetailsList(List<ProductDetails> productDetailsList);

    JSONObject getItemDetails(ItemDetails itemDetails);

    JSONObject getItemDetailsList(List<ItemDetails> itemDetailsList);

    JSONObject calcualteInventoryInfo(ProductDetailsForm productDetailsForm);

    Order placeOrder(ItemDetails itemDetails);

    SalesInfo registerSalesInfo(ProductDetailsForm productDetailsForm);

    ProductDetails registerProductDetails(ProductDetailsForm productDetailsForm);

    ItemDetails registerItemDetails(ProductDetailsForm productDetailsForm);

    List<ItemDetails> getItemDetailsListByProductName(String productName);

    JSONObject getProductNameList();

}
