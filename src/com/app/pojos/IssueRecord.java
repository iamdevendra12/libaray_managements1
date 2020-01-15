package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "issue_record")
public class IssueRecord 
{
  private Integer id;
  private Date issueDate,returnDueDate,returnDate;
  private Double fineAmount;
  private Copies copyId;
  private Users  memeberId;
  
  
  public IssueRecord() {
	System.out.println("in issue record ctor");
}
	public IssueRecord(Date issueDate, Date returnDueDate, Date returnDate, Double fineAmount) {
		super();
		this.issueDate = issueDate;
		this.returnDueDate = returnDueDate;
		this.returnDate = returnDate;
		this.fineAmount = fineAmount;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "issue_date")
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "return_duedate")
	public Date getReturnDueDate() {
		return returnDueDate;
	}
	public void setReturnDueDate(Date returnDueDate) {
		this.returnDueDate = returnDueDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "return_date")
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	@Column(name = "fine_amount")
	public Double getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(Double fineAmount) {
		this.fineAmount = fineAmount;
	}
	
	@ManyToOne
	@JoinColumn(name = "copy_id")
	public Copies getCopyId() {
		return copyId;
	}
	public void setCopyId(Copies copyId) {
		this.copyId = copyId;
	}

	@ManyToOne
	@JoinColumn(name = "member_id")
	public Users getMemeberId() {
		return memeberId;
	}
	public void setMemeberId(Users memeberId) {
		this.memeberId = memeberId;
	}
	@Override
	public String toString() {
		return "IssueRecord [id=" + id + ", issueDate=" + issueDate + ", returnDueDate=" + returnDueDate
				+ ", returnDate=" + returnDate + ", fineAmount=" + fineAmount + ", copyId=" + copyId + "]";
	}
	  
  
}
