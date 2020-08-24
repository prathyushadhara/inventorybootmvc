package com.dxctraining.inventorymgt.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.dto.SessionData;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

import java.util.*;


@Controller
public class SupplierController {

    @Autowired
    private ISupplierService supplierservice;
    @Autowired
    private SessionData sessionData;


    
  /*  @PostConstruct
    public void init(){
        Supplier supplier1=new Supplier("prathyusha");
        supplier1=supplierservice.add(supplier1);
        Supplier supplier2=new Supplier("chinni");
        supplier1=supplierservice.add(supplier2);  
    }*/

    @GetMapping("/profile")
    public ModelAndView supplierDetails(@RequestParam("id")int id){
      Supplier sup=supplierservice.findSupplierById(id);
       ModelAndView modelAndView=new ModelAndView("details","supplier",sup);
       return modelAndView;
    }
    @GetMapping("/listall")
    public ModelAndView all(){
       List<Supplier>values=supplierservice.displayAllSuppliers();
        ModelAndView modelAndView=new ModelAndView("list","suppliers",values);
        return modelAndView;
    }
    @GetMapping("/register")
	public ModelAndView registerSupplier() {
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}

	@GetMapping("/processregister")
	public ModelAndView processRegister(@RequestParam("name") String name) {
		System.out.println("inside processregister method, name=" + name);
		Supplier supplier = new Supplier(name);
	supplierservice.add(supplier);
		ModelAndView mv = new ModelAndView("details", "supplier", supplier);
		return mv;
	}
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	 @GetMapping("/processlogin")
	    public ModelAndView processLogin(@RequestParam("id") int id, @RequestParam("password") String password){
	         boolean correct=supplierservice.authenticate(id,password);
	         if(!correct){
	          ModelAndView modelAndView= new ModelAndView("login");
	          return modelAndView;
	         }
	         sessionData.saveLogin(id);
	         Supplier sup=supplierservice.findSupplierById(id);
	         ModelAndView modelAndView=new ModelAndView("details","supplier",sup);
	         return modelAndView;
	    }

	    @GetMapping("/logout")
	    public ModelAndView logout(){
	       sessionData.clear();
	       ModelAndView modelAndView=new ModelAndView("login");
	       return modelAndView;
	    }

	

}

  