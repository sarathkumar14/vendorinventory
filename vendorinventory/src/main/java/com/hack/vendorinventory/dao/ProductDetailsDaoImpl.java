package com.hack.vendorinventory.dao;

import com.hack.vendorinventory.model.ItemDetails;
import com.hack.vendorinventory.model.ProductDetails;
import com.hack.vendorinventory.model.SalesInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository("productDetailsDao")
public class ProductDetailsDaoImpl implements ProductDetailsDao {


    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public List<ItemDetails> getItemDetailsList() {
        List<ItemDetails> itemDetailsList = null;
        String selectProduct = "select ItemDetails from com.hack.vendorinventory.model.ItemDetails ItemDetails";
        try{
            Query query = entityManager.createQuery(selectProduct);
            itemDetailsList = query.getResultList();
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return itemDetailsList != null && !itemDetailsList.isEmpty() ? itemDetailsList : null;
    }

    @Transactional
    @Override
    public ItemDetails getItemDetailsByItemDetailId(Long itemDetailId) {
        List<ItemDetails> itemDetailsList = null;
        String selectProduct = "select ItemDetails from com.hack.vendorinventory.model.ItemDetails ItemDetails where ItemDetails.itemDetailId = :itemDetailId";
        try{
            if(itemDetailId != null){
                Query query = entityManager.createQuery(selectProduct);
                query.setParameter("itemDetailId", itemDetailId);
                itemDetailsList = query.getResultList();
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return itemDetailsList != null && !itemDetailsList.isEmpty() ? itemDetailsList.get(0) : null;
    }

    @Transactional
    @Override
    public List<String> getProductNameList(){
        List<String> productNameList = null;
        String selectProduct = "select ProductDetails.productName from com.hack.vendorinventory.model.ProductDetails ProductDetails";
        try{
            Query query = entityManager.createQuery(selectProduct);
            productNameList = query.getResultList();
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return productNameList != null && !productNameList.isEmpty() ? productNameList : null;

    }

    @Transactional
    @Override
    public List<ItemDetails> getItemDetailsList(Long productDetailId) {
        List<ItemDetails> itemDetailsList = null;
        String selectProduct = "select ItemDetails from com.hack.vendorinventory.model.ItemDetails ItemDetails where ItemDetails.productDetailId = :productDetailId";
        try{
            if(productDetailId != null){
                Query query = entityManager.createQuery(selectProduct);
                query.setParameter("productDetailId", productDetailId);
                itemDetailsList = query.getResultList();
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return itemDetailsList != null && !itemDetailsList.isEmpty() ? itemDetailsList : null;
    }

    @Transactional
    @Override
    public List<ItemDetails> getItemDetailsListByProductName(String productName){
        List<ItemDetails> itemDetailsList = null;
        String selectProduct = "select ItemDetails from com.hack.vendorinventory.model.ItemDetails ItemDetails where ItemDetails.productName = :productName";
        try{
            if(productName != null){
                Query query = entityManager.createQuery(selectProduct);
                query.setParameter("productName", productName);
                itemDetailsList = query.getResultList();
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return itemDetailsList != null && !itemDetailsList.isEmpty() ? itemDetailsList : null;
    }

    @Transactional
    @Override
    public List<ItemDetails> getItemDetailsList(String organizationName) {
        List<ItemDetails> itemDetailsList = null;
        String selectProduct = "select ItemDetails from com.hack.vendorinventory.model.ItemDetails ItemDetails where ItemDetails.organizationName = :organizationName";
        try{
            if(organizationName != null){
                Query query = entityManager.createQuery(selectProduct);
                query.setParameter("organizationName", organizationName);
                itemDetailsList = query.getResultList();
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return itemDetailsList != null ? itemDetailsList : null;
    }

    @Transactional
    @Override
    public List<ProductDetails> getProductDetailsList(String organizationName) {
        List<ProductDetails> productDetailsList = null;
        String selectProduct = "select ProdcutDetails from com.hack.vendorinventory.model.ProdcutDetails ProdcutDetails where ProdcutDetails.organizationName = :organizationName";
        try{
            if(organizationName != null){
                Query query = entityManager.createQuery(selectProduct);
                query.setParameter("organizationName", organizationName);
                productDetailsList = query.getResultList();
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return productDetailsList != null && !productDetailsList.isEmpty() ? productDetailsList : null;
    }

    @Transactional
    @Override
    public ProductDetails saveProductDetails(ProductDetails productDetails) {
        ProductDetails oProductDetails = null;
        try{
            if(productDetails != null){
                oProductDetails = entityManager.merge(productDetails);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return oProductDetails != null ? oProductDetails : null;
    }

    @Transactional
    @Override
    public ProductDetails getProductDetailsByName(String productName){
        List<ProductDetails> productDetailsList = null;
        String selectProduct = "select ProdcutDetails from com.hack.vendorinventory.model.ProdcutDetails ProdcutDetails where ProdcutDetails.productName = :productName";
        try{
            if(productName != null){
                Query query = entityManager.createQuery(selectProduct);
                query.setParameter("productName", productName);
                productDetailsList = query.getResultList();
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return productDetailsList != null && !productDetailsList.isEmpty() ? productDetailsList.get(0) : null;
    }

    @Transactional
    @Override
    public ItemDetails saveItemDetails(ItemDetails itemDetails) {
        ItemDetails oItemDetails = null;
        try{
            if(itemDetails != null){
                oItemDetails = entityManager.merge(itemDetails);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return oItemDetails != null ? oItemDetails : null;
    }

    @Transactional
    @Override
    public SalesInfo saveSalesInfo(SalesInfo salesInfo) {
        SalesInfo oSalesInfo = null;
        try{
            if(salesInfo != null){
                oSalesInfo = entityManager.merge(salesInfo);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return oSalesInfo != null ? oSalesInfo : null;
    }

}
