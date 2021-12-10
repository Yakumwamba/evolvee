package io.evolvee.poc.core.users.inventory;

import io.evolvee.poc.core.items.BaseItem;

public class UserItem {
	private int id;
	private BaseItem baseItem;
	private int state;

	public UserItem(int id, BaseItem baseItem, int state) {
		this.id = id;
		this.baseItem = baseItem;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public BaseItem getBaseItem() {
		return baseItem;
	}

	public int getState() {
		return state;
	}

}
