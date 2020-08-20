package com.dxctraining.inventorymgt.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.phone.service.IPhoneService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Controller
public class PhoneController extends Item {
	 @Autowired
	    private IPhoneService phoneservice;
       @Autowired
	    private ISupplierService supplierservice;
	 @PostConstruct
	    public void init(){
		Supplier supplier3=new Supplier("sai");
	        supplier3=supplierservice.add(supplier3);
	        Supplier supplier4=new Supplier("lasya");
	        supplier4=supplierservice.add(supplier4);
	       Phone phone1=new Phone("mi",supplier3,64);
	        phoneservice.add(phone1);
	        Phone phone2=new Phone("oppo",supplier4,256);
	        phoneservice.add(phone2);
	 }
	        @GetMapping("/phone")
		    public ModelAndView phoneDetails(@RequestParam("id")int id){
		      Phone phone=phoneservice.findPhoneById(id);
		       ModelAndView modelAndView=new ModelAndView("phonedetails","phone",phone);
		       return modelAndView;
		    }
	        @GetMapping("/listallphones")
		    public ModelAndView all(){
		       List<Phone>values=phoneservice.allPhones();
		        ModelAndView modelAndView=new ModelAndView("phonelist","phones",values);
		        return modelAndView;
		    }
	       
}
