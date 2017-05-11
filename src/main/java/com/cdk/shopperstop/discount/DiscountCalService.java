package com.cdk.shopperstop.discount;

import com.cdk.shopperstop.customer.CustomerType;

public interface DiscountCalService {

	public Double getFinalPrice(Double billAmount, CustomerType ctype);

}
