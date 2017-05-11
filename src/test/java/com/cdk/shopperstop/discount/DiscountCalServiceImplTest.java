package com.cdk.shopperstop.discount;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cdk.shopperstop.bill.CustomerBill;
import com.cdk.shopperstop.client.Customer;
import com.cdk.shopperstop.client.CustomerType;

public class DiscountCalServiceImplTest {

	DiscountCalService ds = new DiscountCalServiceImpl();

	@Test
	public void getFinalDiscountPriceTest() {
		Customer ctp = new Customer(CustomerType.PREMIUM);
		Customer ctr = new Customer(CustomerType.REGULAR);

		CustomerBill billp1 = new CustomerBill(new Double(15000), ctp);
		CustomerBill billr1 = new CustomerBill(new Double(15000), ctr);
		CustomerBill billp2 = new CustomerBill(new Double(0), ctp);
		CustomerBill billr2 = new CustomerBill(new Double(0), ctr);
		CustomerBill billp3 = new CustomerBill(new Double(5000), ctp);
		CustomerBill billr3 = new CustomerBill(new Double(5000), ctr);
		CustomerBill billp4 = new CustomerBill(new Double(10000), ctp);
		CustomerBill billr4 = new CustomerBill(new Double(10000), ctr);

		CustomerBill billp5 = new CustomerBill(new Double(12000), ctp);
		CustomerBill billr5 = new CustomerBill(new Double(12000), ctr);

		Double value = ds.getFinalDiscountPrice(billp1);
		// Double value=ds.getFinalDiscountPrice(new Double(0), ctp);
		assertEquals(value, 12000, 0.00);
		value = ds.getFinalDiscountPrice(billr1);
		assertEquals(value, 13500, 0.00);
		value = ds.getFinalDiscountPrice(billp2);
		assertEquals(value, 0, 0.00);
		value = ds.getFinalDiscountPrice(billr2);
		assertEquals(value, 0, 0.00);
		value = ds.getFinalDiscountPrice(billp3);
		assertEquals(value, 4500, 0.00);
		value = ds.getFinalDiscountPrice(billr3);
		assertEquals(value, 5000, 0.00);

		value = ds.getFinalDiscountPrice(billp4);
		assertEquals(value, 8500, 0.00);
		value = ds.getFinalDiscountPrice(billr4);
		assertEquals(value, 9500, 0.00);

		value = ds.getFinalDiscountPrice(billp5);
		assertEquals(value, 9900, 0.00);
		value = ds.getFinalDiscountPrice(billr5);
		assertEquals(value, 11100, 0.00);

	}
}
