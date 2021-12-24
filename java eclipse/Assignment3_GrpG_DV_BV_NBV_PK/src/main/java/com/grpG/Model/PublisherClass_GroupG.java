package com.grpG.Model;

public class PublisherClass_GroupG {
	private int pub_id;
	public int getPub_id() {
		return pub_id;
	}
	public void setPub_id(int pub_id) {
		this.pub_id = pub_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String address;
	private String name;
	public PublisherClass_GroupG(int pub_id,String name,String Address) {
		super();
		this.pub_id=pub_id;
		this.name=name;
		this.address=Address;
	}
	public PublisherClass_GroupG(int pub_id) {
		super();
		this.pub_id=pub_id;
	}
}
