package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "copies")
public class Copies 
{
  private Integer id,rack;
  private String status;
  private Books bookId;
  private List<IssueRecord> issueList=new ArrayList<IssueRecord>();
  
  public Copies() {
	System.out.println("in copies ctor");
}
	public Copies(Integer rack, String status) {
		super();
		this.rack = rack;
		this.status = status;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	public Integer getRack() {
		return rack;
	}
	public void setRack(Integer rack) {
		this.rack = rack;
	}
	
	@Column(name="status",nullable = false)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@ManyToOne
	@JoinColumn(name="book_id")
	public Books getBookId() {
		return bookId;
	}
	public void setBookId(Books bookId) {
		this.bookId = bookId;
	}
	
	@OneToMany(mappedBy = "copyId",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<IssueRecord> getIssueList() {
		return issueList;
	}
	public void setIssueList(List<IssueRecord> issueList) {
		this.issueList = issueList;
	}
	
	@Override
	public String toString() {
		return "Copies [id=" + id + ", rack=" + rack + ", status=" + status + ", bookId=" + bookId + "]";
	}
	
	// add helper methods of issue record
	public void addIssueRecord(IssueRecord r)
	{
		issueList.add(r);
		r.setCopyId(this);
	}
	
	public void removeIssueRecord(IssueRecord r)
	{
		issueList.remove(r);
		r.setCopyId(null);
	}
}
