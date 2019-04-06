package com.hack.vendorinventory.controller;

import com.hack.vendorinventory.form.ProductDetailsForm;
import com.hack.vendorinventory.model.ItemDetails;
import com.hack.vendorinventory.service.ProductDetailsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin()
public class ProductDetailController {


    @Autowired
    private ProductDetailsService productDetailsService;

    @RequestMapping(value = "/calculateAndPlaceOrder", method = RequestMethod.GET)
    public String calculateAndPlaceOrder(@ModelAttribute ProductDetailsForm productDetailsForm){
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject = productDetailsService.calcualteInventoryInfo(productDetailsForm);
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/getItemDetailList", method = RequestMethod.GET)
    public String getItemDetailList(@ModelAttribute ProductDetailsForm productDetailsForm){
        JSONObject jsonObject = new JSONObject();
        List<ItemDetails> itemDetailsList = null;
        try{
            itemDetailsList = productDetailsService.getItemDetailsList();
            if(itemDetailsList != null){
                jsonObject = productDetailsService.getItemDetailsList(itemDetailsList);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/getItemDetailListByCustomerName", method = RequestMethod.GET)
    public String getItemDetailListByCustomerName(@ModelAttribute ProductDetailsForm productDetailsForm){
        JSONObject jsonObject = new JSONObject();
        List<ItemDetails> itemDetailsList = null;
        try{
            itemDetailsList = productDetailsService.getItemDetailsList(productDetailsForm.getOrganizationName());
            if(itemDetailsList != null){
                jsonObject = productDetailsService.getItemDetailsList(itemDetailsList);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/getItemDetailListByProductName", method = RequestMethod.GET)
    public String getItemDetailListByProductName(@ModelAttribute ProductDetailsForm productDetailsForm){
        JSONObject jsonObject = new JSONObject();
        List<ItemDetails> itemDetailsList = null;
        try{
            itemDetailsList = productDetailsService.getItemDetailsListByProductName(productDetailsForm.getProductName());
            if(itemDetailsList != null){
                jsonObject = productDetailsService.getItemDetailsList(itemDetailsList);
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/getProductNameList", method = RequestMethod.GET)
    public String getProductNameList(@ModelAttribute ProductDetailsForm productDetailsForm){
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject = productDetailsService.getProductNameList();
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return jsonObject.toString();
    }

}
