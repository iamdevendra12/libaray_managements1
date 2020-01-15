package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payments 
{
   private Integer id;
   private Double amount;
   private String paymentType;
   private Date transactionTime,nextPaymentDueDate;
   private Users userId;
   
   public Payments() {
	System.out.println("in payments ctor");
  }


	public Payments(Double amount, String paymentType, Date transactionTime, Date nextPaymentDueDate) {
		super();
		this.amount = amount;
		this.paymentType = paymentType;
		this.transactionTime = transactionTime;
		this.nextPaymentDueDate = nextPaymentDueDate;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
    public void setId(Integer id) {
		this.id = id;
	}

    @Column(nullable = false)
	public Double getAmount() {
		return amount;
	}
    public void setAmount(Double amount) {
		this.amount = amount;
	}

    @Column(name = "payment_type",nullable = false)
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

    @Temporal(TemporalType.TIME)
    @Column(name = "transaction_time")
	public Date getTransactionTime() {
		return transactionTime;
	}
    public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

     @Temporal(TemporalType.DATE)
     @Column(name = "nextpayment_duedate")
	public Date getNextPaymentDueDate() {
		return nextPaymentDueDate;
	}
	public void setNextPaymentDueDate(Date nextPaymentDueDate) {
		this.nextPaymentDueDate = nextPaymentDueDate;
	}

   @ManyToOne
   @JoinColumn(name = "user_id")
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
	}
   
	
   
}
