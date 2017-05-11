package com.cdk.shopperstop.service;

import java.util.List;
import java.util.Map;

import com.cdk.shopperstop.conf.DiscountCollection;
import com.cdk.shopperstop.pojo.CustomerDiscount;
import com.cdk.shopperstop.pojo.CustomerType;
import com.cdk.shopperstop.pojo.DiscountDTO;

public class DiscountCalServiceImpl implements DiscountCalService {

	public static Map<CustomerType, CustomerDiscount> discountMap = DiscountCollection.getInstance().getDiscountMap();

	public Double getFinalPrice(Double billAmount, CustomerType ctype) {
		if (billAmount == null || billAmount < 0) {
			throw new IllegalArgumentException("Invalid bill amount");
		}
		if (billAmount == 0) {
			return new Double(0);
		}

		CustomerDiscount customerDiscount = discountMap.get(ctype);
		List<DiscountDTO> discountSlab = customerDiscount.getDiscountList();

		int discountSlabCount = discountSlab.size() - 1;
		Double totalDiscountAmount = new Double(0);

		Double basicBillAmount = billAmount;
		while (billAmount > 0 && discountSlabCount >= 0) {
			DiscountDTO discount = discountSlab.get(discountSlabCount);
			if (billAmount >= discount.getLowerBound()) {
				Double amountToBeDiscounted = billAmount - discount.getLowerBound();
				totalDiscountAmount += amountToBeDiscounted * (discount.getDiscount() / 100);
				billAmount = discount.getLowerBound();
			}
			discountSlabCount--;
		}

		return basicBillAmount - totalDiscountAmount;
	}

}
