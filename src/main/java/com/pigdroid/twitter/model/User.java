package com.pigdroid.twitter.model;

public class User extends BaseEntity {

	private String name;

	private User(Builder builder) {
		this.name = builder.name;
	}

	public String getName() {
		return name;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String name;

		private Builder() {
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", toString()=" + super.toString() + "]";
	}

}
