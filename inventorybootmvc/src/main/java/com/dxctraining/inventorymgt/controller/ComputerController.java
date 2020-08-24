package com.dxctraining.inventorymgt.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.computer.entities.Computer;
import com.dxctraining.inventorymgt.computer.service.IComputerService;
import com.dxctraining.inventorymgt.dto.CreateComputerRequest;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;


@RestController
@RequestMapping("/computers")
//@Controller
public class ComputerController extends Item{
	 @Autowired
	    private IComputerService computerservice;
	 @Autowired
	    private ISupplierService supplierservice;
	/* @PostConstruct
	    public void init(){
		Supplier supplier1=new Supplier("priya");
	        supplier1=supplierservice.add(supplier1);
	        Supplier supplier2=new Supplier("chinna");
	        supplier1=supplierservice.add(supplier2);  
	        Computer computer1=new Computer("dell",supplier1,2000);
	        computerservice.add(computer1);
	        Computer computer2=new Computer("hp",supplier2,3000);
	        computerservice.add(computer2);
	       
	    }*/
	 /* @GetMapping("/computer")
	    public ModelAndView computerDetails(@RequestParam("id")int id){
	      Computer computer=computerservice.findComputerById(id);
	       ModelAndView modelAndView=new ModelAndView("computerdetails","computer",computer);
	       return modelAndView;
	    }*/
	  @PostMapping("/add")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Computer create(@RequestBody CreateComputerRequest requestData) {
	        String name = requestData.getName();
	        Supplier supplier=requestData.getSupplier();
	        int diskSize = requestData.getDiskSize(); 
	        Computer computer = new Computer(name,supplier,diskSize);
	        computer = computerservice.add(computer);
	        return computer;
	    }
	  @GetMapping("/get/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public Computer findComputer(@PathVariable("id") int id) {
	        Computer computer = computerservice.findComputerById(id);
	        return computer;
	    }
	  @GetMapping("/listallcomputers")
	    public ModelAndView all(){
	       List<Computer>values=computerservice.allComputers();
	        ModelAndView modelAndView=new ModelAndView("computerlist","computers",values);
	        return modelAndView;
	    }


}
