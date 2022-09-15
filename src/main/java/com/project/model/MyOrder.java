package com.project.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class MyOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer orderid;
	
	LocalDateTime localdtetime;
	String orderstatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	Customer customer;

	@OneToMany(cascade = CascadeType.ALL)
	List<Products>productlist;
	
	@OneToOne(cascade = CascadeType.ALL)
	Address address;
}
