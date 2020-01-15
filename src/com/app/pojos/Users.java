package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users 
{
   private Integer id;
   private String name,email,phone,password;
   private UserRole role;
   private List<IssueRecord> recordList=new ArrayList<IssueRecord>();
   private List<Payments>  paymentList= new ArrayList<Payments>();
   
   public Users() {
	System.out.println("in users ctor");
   }
		public Users(String name, String email, String phone, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(nullable=false,length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length=10,unique = true,nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(length=15)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(length=10,nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	
	@OneToMany(mappedBy = "")
	public List<IssueRecord> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<IssueRecord> recordList) {
		this.recordList = recordList;
	}
	
	
	@OneToMany(mappedBy = "userId",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Payments> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(List<Payments> paymentList) {
		this.paymentList = paymentList;
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password
				+ ", role=" + role + "]";
	}
	
	// adding helper method of issuerecord
	public void addIssueRecord(IssueRecord a)
	{
		recordList.add(a);
		a.setMemeberId(this);
	}
	public void removeIssueRecord(IssueRecord a)
	{
		recordList.remove(a);
		a.setMemeberId(null);
	}
	
	// adding helper method of payment record
	
	public void addPayments(Payments a)
	{
		paymentList.add(a);
		a.setUserId(this);;
	}
	public void removePayments(Payments a)
	{
		paymentList.remove(a);
		a.setUserId(null);;
	}
}
