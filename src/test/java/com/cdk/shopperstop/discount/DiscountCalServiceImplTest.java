package com.cdk.shopperstop.discount;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cdk.shopperstop.bill.CustomerBill;
import com.cdk.shopperstop.customer.Customer;
import com.cdk.shopperstop.customer.CustomerType;

public class DiscountCalServiceImplTest {

	DiscountCalService ds = new DiscountCalServiceImpl();

	@Test
	public void getFinalPriceTest() {
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

		Double value = ds.getFinalPrice(billp1.getBasicBill(), billp1.getCustomer().getType());
		// Double value=ds.getFinalPrice(new Double(0), ctp);
		assertEquals(value, 12000, 0.00);
		value = ds.getFinalPrice(billr1.getBasicBill(),billr1.getCustomer().getType());
		assertEquals(value, 13500, 0.00);
		value = ds.getFinalPrice(billp2.getBasicBill(),billp2.getCustomer().getType());
		assertEquals(value, 0, 0.00);
		value = ds.getFinalPrice(billr2.getBasicBill(), billr2.getCustomer().getType());
		assertEquals(value, 0, 0.00);
		value = ds.getFinalPrice(billp3.getBasicBill(),billp3.getCustomer().getType());
		assertEquals(value, 4500, 0.00);
		value = ds.getFinalPrice(billr3.getBasicBill(),billr3.getCustomer().getType());
		assertEquals(value, 5000, 0.00);

		value = ds.getFinalPrice(billp4.getBasicBill(),billp4.getCustomer().getType());
		assertEquals(value, 8500, 0.00);
		value = ds.getFinalPrice(billr4.getBasicBill(),billr4.getCustomer().getType());
		assertEquals(value, 9500, 0.00);

		value = ds.getFinalPrice(billp5.getBasicBill(),billp5.getCustomer().getType());
		assertEquals(value, 9900, 0.00);
		value = ds.getFinalPrice(billr5.getBasicBill(),billr5.getCustomer().getType());
		assertEquals(value, 11100, 0.00);

	}
}
