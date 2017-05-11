package com.cdk.shopperstop.discount;

import java.util.HashMap;
import java.util.Map;

import com.cdk.shopperstop.client.Customer;
import com.cdk.shopperstop.client.CustomerType;

public class DiscountCalServiceImpl implements DiscountCalService {

	public static Map<CustomerType, CustomerDiscount> discountMap;

	static {

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

	public Double getFinalDiscountPrice(Double bill, Customer ct) {
		if (bill == 0) {
			return bill;
		}

		CustomerDiscount discount = discountMap.get(ct.getType());
		if (discount == null) {
			return bill;
		}
		Map<DiscountRange, Double> tempDiscounts = discount.getDiscounts();

		Double temp = bill;
		Double totalBill = new Double(0);
		if (temp <= 5000) {
			Double precentageDeduction = tempDiscounts.get(DiscountRange.Below_5000);

			Double disc = temp * (precentageDeduction / 100);
			totalBill = temp - disc;
		} else {

			Double precentageDeduction_5000 = tempDiscounts.get(DiscountRange.Below_5000);
			Double precentageDeduction_10000 = tempDiscounts.get(DiscountRange.Below_10000);
			if (temp > 5000 && temp <= 10000) {

				Double disc1 = 5000 * (precentageDeduction_5000 / 100);
				Double disc2 = (temp - 5000) * (precentageDeduction_10000 / 100);
				totalBill = temp - (disc1 + disc2);

			} else {
				Double precentageDeduction_above_10000 = tempDiscounts.get(DiscountRange.Above_10000);
				Double disc1 = 5000 * (precentageDeduction_5000 / 100);
				Double disc2 = 5000 * (precentageDeduction_10000 / 100);
				Double disc3 = (temp - 10000) * (precentageDeduction_above_10000 / 100);
				totalBill = temp - (disc1 + disc2 + disc3);
			}

		}

		return totalBill;
	}

}
