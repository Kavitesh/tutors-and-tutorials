package com.tnt.api.domain;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractContent {

	private String author;

	private Long createdAt;

	@NotBlank
	private String content;

	private List<AbstractContent> comments;

	private Map<String, ReactionType> reactions;

}
