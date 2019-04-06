package com.hack.vendorinventory.service;

import com.hack.vendorinventory.dao.ProductDetailsDao;
import com.hack.vendorinventory.form.ProductDetailsForm;
import com.hack.vendorinventory.model.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;


@Service("productDetailsService")
public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Autowired
    private ProductDetailsDao productDetailsDao;

    @Override
    public List<ItemDetails> getItemDetailsList() {
        List<ItemDetails> itemDetailsList = null;
        try{
            itemDetailsList = productDetailsDao.getItemDetailsList();
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return itemDetailsList != null && !itemDetailsList.isEmpty() ? itemDetailsList : null;
    }

    @Override
    public List<ItemDetails> getItemDetailsList(Long productId) {
        List<ItemDetails> itemDetailsList = null;
        try{
            if(productId != null){
                itemDetailsList = productDetailsDao.getItemDetailsList(productId);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return itemDetailsList != null && !itemDetailsList.isEmpty() ? itemDetailsList : null;
    }

    @Override
    public List<ItemDetails> getItemDetailsList(String organizationName) {
        List<ItemDetails> itemDetailsList = null;
        try{
            if(organizationName != null){
                itemDetailsList = productDetailsDao.getItemDetailsList(organizationName);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return itemDetailsList != null && !itemDetailsList.isEmpty() ? itemDetailsList : null;
    }

    @Override
    public List<ProductDetails> getProductDetailsList(String organizationName) {
        List<ProductDetails> productDetailsList = null;
        try{
            if(organizationName != null){
                productDetailsList = productDetailsDao.getProductDetailsList(organizationName);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return productDetailsList != null && !productDetailsList.isEmpty() ? productDetailsList : null;
    }

    @Override
    public ProductDetails saveProductDetails(ProductDetails productDetails) {
        ProductDetails oProductDetails = null;
        try{
            if(productDetails != null){
                oProductDetails = productDetailsDao.saveProductDetails(productDetails);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return oProductDetails != null ? oProductDetails : null;
    }

    @Override
    public ItemDetails saveItemDetails(ItemDetails itemDetails) {
        ItemDetails oItemDetails = null;
        try{
            if(itemDetails != null){
                oItemDetails = productDetailsDao.saveItemDetails(itemDetails);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return oItemDetails != null ? oItemDetails : null;
    }

    @Override
    public SalesInfo saveSalesInfo(SalesInfo salesInfo) {
        SalesInfo oSalesInfo = null;
        try{
            if(salesInfo != null){
                oSalesInfo = productDetailsDao.saveSalesInfo(salesInfo);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return oSalesInfo != null ? oSalesInfo : null;
    }

    @Override
    public ItemDetails getItemDetailsByItemDetailId(Long itemDetailId) {
        ItemDetails itemDetails = null;
        try{
            if(itemDetailId != null){
                itemDetails = productDetailsDao.getItemDetailsByItemDetailId(itemDetailId);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return itemDetails != null ? itemDetails : null;
    }

    @Override
    public JSONObject getProductDetails(ProductDetails productDetails){
        JSONObject resultJson = new JSONObject();
        try{
            if (productDetails != null){
                resultJson.put("organizationId", productDetails.getOrganizationId());
                resultJson.put("organizationName", productDetails.getOrganizationName());
                resultJson.put("productName", productDetails.getProductName());
                resultJson.put("productDetailId", productDetails.getProductDetailId());
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return resultJson;
    }

    @Override
    public JSONObject getProductDetailsList(List<ProductDetails> productDetailsList){
        JSONObject resultJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try{
            if(productDetailsList != null && !productDetailsList.isEmpty()){
                for (ProductDetails productDetails : productDetailsList){
                    if(productDetails != null){
                        jsonArray.put(getProductDetails(productDetails));
                    }
                }
                resultJson.put("productDetails", jsonArray);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return resultJson;
    }

    @Override
    public JSONObject getItemDetails(ItemDetails itemDetails){
        JSONObject resultJson = new JSONObject();
        try{
            if (itemDetails != null){
                resultJson.put("itemDetailId", itemDetails.getItemDetailId());
                resultJson.put("categoryId", itemDetails.getCategoryId());
                resultJson.put("itemName", itemDetails.getItemName());
                resultJson.put("currentShelfQuantity", itemDetails.getCurrentShelfQuantity());
                resultJson.put("itemThreshold", itemDetails.getItemThreshold());
                resultJson.put("requiredQuantity", itemDetails.getRequiredQuantity());
                resultJson.put("orderValue", itemDetails.getOrderValue());
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return resultJson;
    }

    @Override
    public JSONObject getItemDetailsList(List<ItemDetails> itemDetailsList){
        JSONObject resultJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try{
            if(itemDetailsList != null && !itemDetailsList.isEmpty()){
                for (ItemDetails itemDetails : itemDetailsList){
                    if(itemDetails != null){
                        jsonArray.put(getItemDetails(itemDetails));
                    }
                }
                resultJson.put("itemDetails", jsonArray);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return resultJson;
    }

    @Override
    public JSONObject calcualteInventoryInfo(ProductDetailsForm productDetailsForm){
        JSONObject jsonObject = new JSONObject();
        List<ItemDetails> itemDetailsList = null;
        Double calculatedQuantity = null;
        Double cShelfQuantity = null;
        ItemDetails oItemDetails = null;
        SalesInfo salesInfo = null;
        Order order = null;
        int loopCount = 0;
        try{
            if(productDetailsForm.getProductQuantity() != null){
                itemDetailsList = productDetailsDao.getItemDetailsListByProductName(productDetailsForm.getProductName());
                for (ItemDetails itemDetails : itemDetailsList){
                    loopCount ++;
                    if(itemDetails != null){
                        calculatedQuantity = itemDetails.getRequiredQuantity() * productDetailsForm.getProductQuantity();
                        cShelfQuantity = itemDetails.getCurrentShelfQuantity();
                        calculatedQuantity = cShelfQuantity - calculatedQuantity;
                        itemDetails.setCurrentShelfQuantity(calculatedQuantity);
                        oItemDetails = productDetailsDao.saveItemDetails(itemDetails);
                        if(oItemDetails != null){
                            if(loopCount == itemDetailsList.size()){
                                productDetailsForm.setCategoryId(itemDetails.getCategoryId());
                                productDetailsForm.setOrganizationName(itemDetails.getOrganizationName());
                                salesInfo = registerSalesInfo(productDetailsForm);
                            }
                            if(oItemDetails.getItemThreshold().doubleValue() == calculatedQuantity.doubleValue() || oItemDetails.getItemThreshold().doubleValue() < calculatedQuantity.doubleValue()){
                                order = placeOrder(oItemDetails);
                                if(order != null){
                                    jsonObject.put("orderDetails", "Your order for " + oItemDetails.getItemName() + "has been placed and shelf quantity will be updated once order received");
                                }
                            }else{
                                jsonObject.put("orderDetails", "Your current shelf value is enough, we will place your order once your shelf valur is reduced");
                            }
                        }
                    }
                }
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return jsonObject;
    }

    @Override
    public Order placeOrder(ItemDetails itemDetails){
        Order order = null;
        Double orderQuantity = null;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        try{
            if(itemDetails != null){

                if(itemDetails.getCurrentShelfQuantity() < itemDetails.getItemThreshold()){
                    orderQuantity = itemDetails.getRequiredQuantity() + itemDetails.getItemThreshold() - itemDetails.getCurrentShelfQuantity();
                }else{
                    orderQuantity = itemDetails.getRequiredQuantity();
                }

                order = new OrderImpl();
                order.setItemDetailsId(itemDetails.getItemDetailId());
                order.setItemOrderQuantity(orderQuantity);
                order.setOrderTime(timestamp);

            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return order != null ? order : null;
    }

    @Override
    public SalesInfo registerSalesInfo(ProductDetailsForm productDetailsForm){
        SalesInfo salesInfo = new SalesInfoImpl();
        try{
            salesInfo.setCategoryId(productDetailsForm.getCategoryId());
            salesInfo.setProductName(productDetailsForm.getProductName());
            salesInfo.setProductQuantity(productDetailsForm.getProductQuantity());
            salesInfo.setOrganizationName(productDetailsForm.getOrganizationName());
            salesInfo.setProductRate(productDetailsForm.getProductRate());
            salesInfo = saveSalesInfo(salesInfo);
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return salesInfo != null ? salesInfo : null;
    }

    @Override
    public ProductDetails registerProductDetails(ProductDetailsForm productDetailsForm){
        ProductDetails productDetails = new ProductDetailsImpl();
        try{
            productDetails.setOrganizationId(productDetailsForm.getOrganizationId());
            productDetails.setOrganizationName(productDetailsForm.getOrganizationName());
            productDetails.setProductName(productDetails.getProductName());
            productDetails = saveProductDetails(productDetails);
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return productDetails != null ? productDetails : null;
    }

    @Override
    public ItemDetails registerItemDetails(ProductDetailsForm productDetailsForm){
        ItemDetails itemDetails = new ItemDetailsImpl();
        ProductDetails productDetails = null;
        try{
            productDetails = productDetailsDao.getProductDetailsByName(productDetailsForm.getProductName());
            itemDetails.setCurrentShelfQuantity(productDetailsForm.getCurrentShelValue());
            itemDetails.setCategoryId(productDetailsForm.getCategoryId());
            itemDetails.setItemName(productDetailsForm.getItemName());
            itemDetails.setItemThreshold(productDetailsForm.getItemThreshold());
            itemDetails.setOrderValue(productDetailsForm.getOrderValue());
            itemDetails.setRequiredQuantity(productDetailsForm.getRequiredQuantity());
            itemDetails.setProductDetailsId(productDetails.getProductDetailId());
            itemDetails.setProductName(productDetails.getProductName());
            itemDetails = saveItemDetails(itemDetails);
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return itemDetails != null ? itemDetails : null;
    }

    @Override
    public JSONObject getProductNameList(){
        JSONObject jsonObject = new JSONObject();
        JSONObject tempJson = null;
        JSONArray jsonArray = new JSONArray();
        List<String> productNameList = null;
        try{
            productNameList = productDetailsDao.getProductNameList();
            for(String productName : productNameList){
                tempJson = new JSONObject();
                if (productName != null){
                    tempJson.put("value", productName);
                    tempJson.put("label", productName);
                    jsonArray.put(tempJson);
                }
            }
            jsonObject.put("productNameList", jsonArray);
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return jsonObject;
    }

    @Override
    public List<ItemDetails> getItemDetailsListByProductName(String productName){
        List<ItemDetails> itemDetailsList = null;
        try{
            if(productName != null){
                itemDetailsList = productDetailsDao.getItemDetailsListByProductName(productName);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return itemDetailsList != null && !itemDetailsList.isEmpty() ? itemDetailsList : null;
    }

}
