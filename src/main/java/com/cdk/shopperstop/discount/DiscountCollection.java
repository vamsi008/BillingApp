package com.cdk.shopperstop.discount;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.cdk.shopperstop.customer.CustomerType;

public class DiscountCollection {
	
	private static DiscountCollection instance=new DiscountCollection();
	protected  Map<CustomerType, CustomerDiscount> discountMap;
	
	private DiscountCollection(){
		
		discountMap = new HashMap<CustomerType, CustomerDiscount>();
		CustomerDiscount cdRegular = new CustomerDiscount();
		
		List<DiscountDTO> discountList = new LinkedList<DiscountDTO>();
		
		DiscountDTO discDTO=new DiscountDTO(new Double(0),new Double(5000),new Double(0));
		DiscountDTO discDTO2=new DiscountDTO(new Double(5000),new Double(10000),new Double(10));
		DiscountDTO discDTO3=new DiscountDTO(new Double(10000),Double.MAX_VALUE,new Double(20));
		discountList.add(discDTO);
		discountList.add(discDTO2);
		discountList.add(discDTO3);
		
		cdRegular.discountList=discountList;
		
		
		CustomerDiscount cdPremium = new CustomerDiscount();
		
		List<DiscountDTO> discountListPremium = new LinkedList<DiscountDTO>();
		
		DiscountDTO discDTO4=new DiscountDTO(new Double(0),new Double(5000),new Double(10));
		DiscountDTO discDTO5=new DiscountDTO(new Double(5000),new Double(10000),new Double(20));
		DiscountDTO discDTO6=new DiscountDTO(new Double(10000),Double.MAX_VALUE,new Double(30));
		discountListPremium.add(discDTO4);
		discountListPremium.add(discDTO5);
		discountListPremium.add(discDTO6);
		
		cdPremium.discountList=discountListPremium;
		
		discountMap.put(CustomerType.REGULAR, cdRegular);
		discountMap.put(CustomerType.PREMIUM, cdPremium);
		
		
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
