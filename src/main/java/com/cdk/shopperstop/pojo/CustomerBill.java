package com.cdk.shopperstop.pojo;

import java.util.UUID;

public class CustomerBill {

	private final UUID id;
	private final Customer ct;
	private final Double basicBill;
	private Double finalBill;

	public CustomerBill(Double basicBill, Customer ct) throws IllegalArgumentException {
		this.id = UUID.randomUUID();
		this.ct = ct;
		if (basicBill < 0) {
			throw new IllegalArgumentException("Bill Amount cannot be negative.");
		}
		this.basicBill = basicBill;

	}

	public UUID getId() {
		return id;
	}

	public Customer getCustomer() {
		return ct;
	}

	public Double getBasicBill() {
		return basicBill;
	}

	public Double getFinalBill() {
		return finalBill;
	}

	public void setFinalBill(Double finalBill) {
		this.finalBill = finalBill;
	}

}
