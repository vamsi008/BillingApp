package com.cdk.shopperstop.discount;

import java.util.LinkedList;
import java.util.List;

public class CustomerDiscount {

	//Map<DiscountRange, Double> discounts = new HashMap<DiscountRange, Double>();
	
	List<DiscountDTO> discountList = new LinkedList<DiscountDTO>();

	public List<DiscountDTO> getDiscountList() {
		return discountList;
	}

	public void setDiscountList(List<DiscountDTO> discountList) {
		this.discountList = discountList;
	}
	


}
