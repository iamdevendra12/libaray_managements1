package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="books")
public class Books 
{
  private Integer id,isbn;
  private String name,author,subject;
  private Double price;
  private List<Copies> copyList=new ArrayList<Copies>();
  
  
  public Books() {
	System.out.println("in books ctor");
 }
	public Books(Integer isbn, String name, String author, String subject, Double price) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.price = price;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "is_bn")
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	
	@Column(name = "book_name",length = 50,nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "author",length = 30)
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column(name = "subject",length = 50,nullable = false)
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Column(nullable = false)
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	@OneToMany(mappedBy = "bookId",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Copies> getCopyList() {
		return copyList;
	}
	public void setCopyList(List<Copies> copyList) {
		this.copyList = copyList;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", isbn=" + isbn + ", name=" + name + ", author=" + author + ", subject=" + subject
				+ ", price=" + price + "]";
	}
  
	
	// add helper methods of copies
	public void addCopies(Copies c)
	{
		copyList.add(c);
		c.setBookId(this);
	}
	
	public void removeCopies(Copies c)
	{
		copyList.remove(c);
		c.setBookId(null);
	}
}
