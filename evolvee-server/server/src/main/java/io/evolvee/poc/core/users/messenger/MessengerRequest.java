package io.evolvee.poc.core.users.messenger;

import io.evolvee.poc.core.users.User;

public class MessengerRequest {

	private User from;
	private User to;

	public User getFrom() {
		return from;
	}

	public User getTo() {
		return to;
	}

	public MessengerRequest(User from, User to) {
		super();
		this.from = from;
		this.to = to;
	}

}
