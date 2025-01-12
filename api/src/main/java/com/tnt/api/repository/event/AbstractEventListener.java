package com.tnt.api.repository.event;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

public abstract class AbstractEventListener<E> extends AbstractMongoEventListener<E> {

	@Autowired
	Validator validator;

	public void onBeforeSave(BeforeSaveEvent<E> event) {
		validate(event.getSource());
		onBeforeSave(event.getSource(), event.getDocument());
		event.getDocument().remove("_class");
	}

	public void onBeforeSave(E domain, Document document) {
	};

	private <T> void validate(T filledDTO) {
		Set<ConstraintViolation<T>> violations = validator.validate(filledDTO);
		if (violations.size() > 0) {
			throw new RuntimeException(violations.iterator().next().getMessageTemplate());
		}
	}

}
