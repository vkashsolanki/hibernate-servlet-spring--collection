package com.flowertree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Flower_Tree")
public class FlowerTree {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int flowerTreeId;
	@Column(name = "Flower_Name")
	private String flowerTreeName;
	@Column(name = "Flower_Description")
	private String flowerTreeDescription;
	@Column(name = "Flower_Price")
	private long flowerTreePrice;
	
	public FlowerTree() {
		super();
		
	}
	
	
	public int getFlowerTreeId() {
		return flowerTreeId;
	}
	public void setFlowerTreeId(int flowerTreeId) {
		this.flowerTreeId = flowerTreeId;
	}
	public String getFlowerTreeName() {
		return flowerTreeName;
	}
	public void setFlowerTreeName(String flowerTreeName) {
		this.flowerTreeName = flowerTreeName;
	}
	public String getFlowerTreeDescription() {
		return flowerTreeDescription;
	}
	public void setFlowerTreeDescription(String flowerTreeDescription) {
		this.flowerTreeDescription = flowerTreeDescription;
	}
	public long getFlowerTreePrice() {
		return flowerTreePrice;
	}
	public void setFlowerTreePrice(long flowerTreePrice) {
		this.flowerTreePrice = flowerTreePrice;
	}

	
	public FlowerTree(int flowerTreeId, String flowerTreeName, String flowerTreeDescription, long flowerTreePrice) {
		super();
		this.flowerTreeId = flowerTreeId;
		this.flowerTreeName = flowerTreeName;
		this.flowerTreeDescription = flowerTreeDescription;
		this.flowerTreePrice = flowerTreePrice;
	}
	@Override
	public String toString() {
		return "FlowerTree [flowerTreeId=" + flowerTreeId + ", flowerTreeName=" + flowerTreeName
				+ ", flowerTreeDescription=" + flowerTreeDescription + ", flowerTreePrice=" + flowerTreePrice + "]";
	}
	
	

}
