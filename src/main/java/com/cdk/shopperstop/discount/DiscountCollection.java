package com.cdk.shopperstop.discount;

import java.util.HashMap;
import java.util.Map;

import com.cdk.shopperstop.customer.CustomerType;

public class DiscountCollection {
	
	private static DiscountCollection instance=new DiscountCollection();
	protected  Map<CustomerType, CustomerDiscount> discountMap;
	
	private DiscountCollection(){
		
		discountMap = new HashMap<CustomerType, CustomerDiscount>();
		Map<DiscountRange, Double> regular = new HashMap<DiscountRange, Double>();
		regular.put(DiscountRange.Below_5000, new Double(0));
		regular.put(DiscountRange.Below_10000, new Double(10));
		regular.put(DiscountRange.Above_10000, new Double(20));

		Map<DiscountRange, Double> premium = new HashMap<DiscountRange, Double>();
		premium.put(DiscountRange.Below_5000, new Double(10));
		premium.put(DiscountRange.Below_10000, new Double(20));
		premium.put(DiscountRange.Above_10000, new Double(30));
		discountMap.put(CustomerType.REGULAR, new CustomerDiscount(regular));
		discountMap.put(CustomerType.PREMIUM, new CustomerDiscount(premium));
		
	}
	
	
	public Map<CustomerType, CustomerDiscount> getDiscountMap() {
		return discountMap;
	}


	public void setDiscountMap(Map<CustomerType, CustomerDiscount> discountMap) {
		this.discountMap = discountMap;
	}


	public static DiscountCollection getInstance(){
	      return instance;
	   }


}
