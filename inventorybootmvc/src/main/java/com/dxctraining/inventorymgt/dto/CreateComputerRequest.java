package com.dxctraining.inventorymgt.dto;

import com.dxctraining.inventorymgt.item.entities.Item;

public class CreateComputerRequest extends Item {

    private String name;

    private int diskSize;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(int diskSize) {
		this.diskSize = diskSize;
	}



}
