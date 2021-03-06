package com.dxctraining.inventorymgt.computer.service;

import java.util.List;

import com.dxctraining.inventorymgt.computer.entities.Computer;


public interface IComputerService {
    Computer findComputerById(int id);

    void remove(int id);

	Computer add(Computer computer);
	List<Computer> allComputers();
}