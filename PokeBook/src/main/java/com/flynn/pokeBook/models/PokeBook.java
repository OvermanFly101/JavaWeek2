package com.flynn.pokeBook.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity //represents an entity model for out application
@Table(name="PokeBooks") //sets this as a table in the database
public class PokeBook {
    @Id //sets this as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //sets this as an auto-incrementing value
    private Long id;
    @NotNull //adds validation that the column must be null
    @Size(min = 5, max = 200) //specifies the range at which the columns should be at (validation)
    private String name;
    @NotNull
    @Size(min = 5, max = 200)
    private String vendor;
    @NotNull
    @Min(value=0)
    private double amount;
    @NotNull
    @Size(min = 5, max = 400)
    private String description;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public PokeBook() {
    }
    
    public PokeBook(String name, String vendor, double amount, String description) {
        this.name = name;
        this.vendor = vendor;
        this.amount = amount;
        this.description = description;
    }
    
    // other getters and setters removed for brevity
    @PrePersist //runs method right before the object is created
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate //runs method when object is modified
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


    
}