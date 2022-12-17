package com.challenge.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
@Table(name = "costumer")
public class Costumer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "password", length = 50)
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "costumer_id")
	@JsonManagedReference
	private List<Address> addresses;
}
