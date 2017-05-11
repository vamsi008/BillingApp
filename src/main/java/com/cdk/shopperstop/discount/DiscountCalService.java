package com.cdk.shopperstop.discount;

import com.cdk.shopperstop.bill.CustomerBill;

public interface DiscountCalService {

	public Double getFinalDiscountPrice(CustomerBill bill);

}
