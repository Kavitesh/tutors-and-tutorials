package com.tnt.api.repository.event;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.tnt.api.domain.Post;

@Component
public class PostEventListner extends AbstractEventListener<Post> {

	public void onBeforeSave(Post post, Document document) {
		if (post.getCreatedAt() == null) {
			post.setCreatedAt(Instant.now().getEpochSecond());
		}

		if (post.getPermalink() == null) {
			String permaLink = post.getTitle().replaceAll("\\s", "-");
			permaLink = permaLink.replaceAll("\\W", "");
			permaLink = permaLink.toLowerCase() + ThreadLocalRandom.current().nextInt();
			post.setPermalink(permaLink);
			document.put("permalink", permaLink);
		}

	}
}
