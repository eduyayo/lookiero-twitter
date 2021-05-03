package com.pigdroid.twitter.model;

import java.util.UUID;

public abstract class BaseEntity {

	private Long id = UUID.randomUUID().getLeastSignificantBits();

	private Long creationTime = System.currentTimeMillis();

	public Long getId() {
		return id;
	}

	public Long getCreationTime() {
		return creationTime;
	}

	@Override
	public String toString() {
		return "BaseEntity [id=" + id + ", creationTime=" + creationTime + "]";
	}

}
