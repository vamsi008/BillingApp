package com.cdk.shopperstop.utils;

import com.cdk.shopperstop.client.CustomerType;

public class ShopperstopUtil {

	public static CustomerType getCustomerType(String customer) {

		if (customer.equals("premium")) {
			return CustomerType.PREMIUM;
		}

		return CustomerType.REGULAR;
	}

}
