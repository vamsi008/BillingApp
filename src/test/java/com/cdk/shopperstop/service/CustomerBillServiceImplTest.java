package com.cdk.shopperstop.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cdk.shopperstop.pojo.Customer;
import com.cdk.shopperstop.pojo.CustomerBill;
import com.cdk.shopperstop.pojo.CustomerType;
import com.cdk.shopperstop.service.CustomerBillService;
import com.cdk.shopperstop.service.CustomerBillServiceImpl;

public class CustomerBillServiceImplTest {

	CustomerBillService cs;

	@Before
	public void runOnceBeforeClass() {
		cs = new CustomerBillServiceImpl();

	}

	@Test
	public void generateBillTest() {

		CustomerBill bill1 = new CustomerBill(new Double(15000), new Customer(CustomerType.PREMIUM));
		cs.generateBill(bill1);
		assertEquals(bill1.getFinalBill(), 12000, 0.00);
		CustomerBill bill2 = new CustomerBill(new Double(15000), new Customer(CustomerType.REGULAR));
		cs.generateBill(bill2);
		assertEquals(bill2.getFinalBill(), 13500, 0.00);
	}

}
