package com.tnt.api.domain;

import javax.validation.constraints.NotBlank;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Author {

	private String _id;

	@NotBlank
	private String name;

	@NotBlank
	private String username;

	private String description;

	@NotBlank
	private String password;

	private String email;

}
