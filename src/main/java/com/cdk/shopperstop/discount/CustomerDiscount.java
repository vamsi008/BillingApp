package com.cdk.shopperstop.discount;

import java.util.HashMap;
import java.util.Map;

public class CustomerDiscount {

	Map<DiscountRange, Double> discounts = new HashMap<DiscountRange, Double>();

	public CustomerDiscount(Map<DiscountRange, Double> discounts) {
		this.discounts = discounts;
	}

	public Map<DiscountRange, Double> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Map<DiscountRange, Double> discounts) {
		this.discounts = discounts;
	}

}
