package com.pigdroid.twitter.model;

import java.util.Comparator;

public class Message extends BaseEntity {

	public static final Comparator<? super Message> BY_DATE_COMPARATOR = new Comparator<Message>() {

		@Override
		public int compare(Message o1, Message o2) {
			return o2.getCreationTime().compareTo(o1.getCreationTime());
		}

	};

	private String userName;

	private String contents;

	private Message(Builder builder) {
		this.userName = builder.userName;
		this.contents = builder.contents;
	}

	public String getContents() {
		return contents;
	}

	public String getUserName() {
		return userName;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String userName;
		private String contents;

		private Builder() {
		}

		public Builder withUserName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder withContents(String contents) {
			this.contents = contents;
			return this;
		}

		public Message build() {
			return new Message(this);
		}
	}

	@Override
	public String toString() {
		return "Message [userName=" + userName + ", contents=" + contents + ", toString()=" + super.toString() + "]";
	}

}
