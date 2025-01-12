package com.tnt.api.domain;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Post extends AbstractContent {

	private String _id;

	private String permalink;

	@NotBlank
	private String title;

	private List<String> lables;

}
