package com.cdk.shopperstop.bill;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cdk.shopperstop.customer.Customer;
import com.cdk.shopperstop.customer.CustomerType;

public class CustomerBillServiceImplTest {

	CustomerBillService cs;

	@Before
	public void runOnceBeforeClass() {
		cs = new CustomerBillServiceImpl();

	}

	@Test
	public void generateBillTest() {

		CustomerBill bill1 = new CustomerBill(new Double(15000), new Customer(CustomerType.PREMIUM));
		bill1 = cs.generateBill(bill1);
		assertEquals(bill1.getFinalBill(), 12000, 0.00);
		CustomerBill bill2 = new CustomerBill(new Double(15000), new Customer(CustomerType.REGULAR));
		bill2 = cs.generateBill(bill2);
		assertEquals(bill2.getFinalBill(), 13500, 0.00);
	}

}
