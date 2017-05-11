package com.cdk.shopperstop.utils;

import com.cdk.shopperstop.bill.CustomerBill;
import com.cdk.shopperstop.bill.CustomerBillService;
import com.cdk.shopperstop.bill.CustomerBillServiceImpl;
import com.cdk.shopperstop.client.Customer;

/**
 * Application to generate the bill.
 *
 */
public class App {

	public static void main(String[] args) {

		try {
			CustomerBillService billService = new CustomerBillServiceImpl();
			if (args[1] == null || args[0] == null) {
				throw new NullPointerException("Args cannot be empty");
			}
			Double bill = Double.parseDouble(args[0]);
			CustomerBill cb = new CustomerBill(bill, new Customer(args[1]));
			cb = billService.generateBill(cb);
			System.out.println("The Final bill after discount ::" + cb.getFinalBill());
		} catch (NumberFormatException e) {
			System.out.println("Proper number syntax have to be used.");
			throw e;
		} catch (NullPointerException e) {
			e.getMessage();
			throw e;
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
			throw e;
		} catch (IllegalArgumentException e) {
			e.getMessage();
			throw e;
		}

	}
}
