package com.cdk.shopperstop.bill;

import com.cdk.shopperstop.discount.DiscountCalService;
import com.cdk.shopperstop.discount.DiscountCalServiceImpl;

public class CustomerBillServiceImpl implements CustomerBillService {

	DiscountCalService ds = new DiscountCalServiceImpl();

	public void generateBill(CustomerBill bill) {
		bill.setFinalBill(ds.getFinalPrice(bill.getBasicBill(), bill.getCustomer().getType()));
	}

}
