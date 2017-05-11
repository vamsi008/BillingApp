package com.cdk.shopperstop.discount;

import com.cdk.shopperstop.client.Customer;

public interface DiscountCalService {

	public Double getFinalDiscountPrice(Double bill, Customer ct);

}
