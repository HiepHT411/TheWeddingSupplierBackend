package com.theweddingsupplier.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="feedback")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name ="name")
	@NotBlank(message = "name may not be blank")
	private String name;
	
	@Column(name ="email")
	@NotBlank(message = "email may not be blank")
	private String email;
	
	@Column(name ="phone")
	@NotBlank(message = "phone may not be  blank")
	private String phone;
	
	@Column(name ="note")
	@NotBlank(message = "note may not be blank")
	private String note;
	
}
