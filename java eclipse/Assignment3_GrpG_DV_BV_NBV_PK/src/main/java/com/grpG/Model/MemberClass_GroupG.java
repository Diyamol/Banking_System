package com.grpG.Model;

import java.sql.Date;

public class MemberClass_GroupG {
	private int memb_id;
	private String name;
	private String address;
	private String memb_type;
	private Date memb_date;
	private Date expiry_date;
	public int getMemb_id() {
		return memb_id;
	}
	public void setMemb_id(int memb_id) {
		this.memb_id = memb_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMemb_type() {
		return memb_type;
	}
	public void setMemb_type(String memb_type) {
		this.memb_type = memb_type;
	}
	public Date getMemb_date() {
		return memb_date;
	}
	public void setMemb_date(Date memb_date) {
		this.memb_date = memb_date;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	public MemberClass_GroupG(int memb_Id) {
		super();
		this.memb_id=memb_Id;
	}
	public MemberClass_GroupG(int memb_id2, String name2, String address2, String memb_type2, Date memb_date2,
			Date exp_date) {
		super();
		this.memb_id=memb_id2;
		this.name=name2;
		this.address=address2;
		this.memb_type=memb_type2;
		this.memb_date=memb_date2;
		this.expiry_date=exp_date;
	}
}
