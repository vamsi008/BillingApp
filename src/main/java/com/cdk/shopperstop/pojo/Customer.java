package com.cdk.shopperstop.pojo;

import java.util.UUID;

public class Customer {

	UUID id;
	CustomerType type = CustomerType.REGULAR;

	public Customer(String type) {
		id = UUID.randomUUID();
		if (("premium").equals(type)) {
			this.type = CustomerType.PREMIUM;
		}

	}

	public Customer(CustomerType type) {
		id = UUID.randomUUID();
		this.type = type;

	}

	public UUID getId() {
		return id;
	}

	public CustomerType getType() {
		return type;
	}

}
