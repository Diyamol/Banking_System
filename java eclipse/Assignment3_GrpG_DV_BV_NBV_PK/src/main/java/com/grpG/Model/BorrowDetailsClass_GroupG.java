package com.grpG.Model;

import java.sql.Date;

public class BorrowDetailsClass_GroupG {
	private int borrowId;
	private int bookId;
	private int memb_Id;
	private String issue;
	private Date due_date;
	private Date return_date;
	public BorrowDetailsClass_GroupG(int bookid, int membid, String issuedby, Date dueDate, Date returnDate) {
		super();
		this.bookId=bookid;
		this.memb_Id=membid;
		this.issue=issuedby;
		this.due_date=dueDate;
		this.return_date=returnDate;
	}
	public int getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getMemb_Id() {
		return memb_Id;
	}
	public void setMemb_Id(int memb_Id) {
		this.memb_Id = memb_Id;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
}

