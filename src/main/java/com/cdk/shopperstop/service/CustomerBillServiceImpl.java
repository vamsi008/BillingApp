package com.cdk.shopperstop.service;

import com.cdk.shopperstop.pojo.CustomerBill;

public class CustomerBillServiceImpl implements CustomerBillService {

	DiscountCalService ds = new DiscountCalServiceImpl();

	public void generateBill(CustomerBill bill) {
		bill.setFinalBill(ds.getFinalPrice(bill.getBasicBill(), bill.getCustomer().getType()));
	}

}
