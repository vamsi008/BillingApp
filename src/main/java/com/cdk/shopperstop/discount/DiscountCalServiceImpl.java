package com.cdk.shopperstop.discount;

import java.util.Map;

import com.cdk.shopperstop.bill.CustomerBill;
import com.cdk.shopperstop.customer.Customer;
import com.cdk.shopperstop.customer.CustomerType;

public class DiscountCalServiceImpl implements DiscountCalService {

	public static Map<CustomerType, CustomerDiscount> discountMap = DiscountCollection.getInstance().getDiscountMap();

	public Double getFinalDiscountPrice(CustomerBill customerBill) {
		Double bill = customerBill.getBasicBill();
		Customer ct = customerBill.getCustomer();

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
			if (precentageDeduction == null) {
				precentageDeduction = new Double(0);
			}
			Double disc = temp * (precentageDeduction / 100);
			totalBill = temp - disc;
		} else {

			Double precentageDeduction_5000 = tempDiscounts.get(DiscountRange.Below_5000);
			if (precentageDeduction_5000 == null) {
				precentageDeduction_5000 = new Double(0);
			}
			Double precentageDeduction_10000 = tempDiscounts.get(DiscountRange.Below_10000);
			if (precentageDeduction_10000 == null) {
				precentageDeduction_10000 = new Double(0);
			}
			if (temp > 5000 && temp <= 10000) {

				Double disc1 = 5000 * (precentageDeduction_5000 / 100);
				Double disc2 = (temp - 5000) * (precentageDeduction_10000 / 100);
				totalBill = temp - (disc1 + disc2);

			} else {
				Double precentageDeduction_above_10000 = tempDiscounts.get(DiscountRange.Above_10000);
				if (precentageDeduction_above_10000 == null) {
					precentageDeduction_above_10000 = new Double(0);
				}
				Double disc1 = 5000 * (precentageDeduction_5000 / 100);
				Double disc2 = 5000 * (precentageDeduction_10000 / 100);
				Double disc3 = (temp - 10000) * (precentageDeduction_above_10000 / 100);
				totalBill = temp - (disc1 + disc2 + disc3);
			}

		}

		return totalBill;
	}

}
