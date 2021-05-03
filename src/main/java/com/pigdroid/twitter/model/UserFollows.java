package com.pigdroid.twitter.model;

public class UserFollows extends BaseEntity {

	private String user;
	private String follows;

	private UserFollows(Builder builder) {
		this.user = builder.user;
		this.follows = builder.follows;
	}

	public String getUser() {
		return user;
	}

	public String getFollows() {
		return follows;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String user;
		private String follows;

		private Builder() {
		}

		public Builder withUser(String user) {
			this.user = user;
			return this;
		}

		public Builder withFollows(String follows) {
			this.follows = follows;
			return this;
		}

		public UserFollows build() {
			return new UserFollows(this);
		}

		@Override
		public String toString() {
			return "Builder [user=" + user + ", follows=" + follows + ", toString()=" + super.toString() + "]";
		}
	}

}
