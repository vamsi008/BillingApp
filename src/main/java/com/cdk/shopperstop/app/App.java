package com.cdk.shopperstop.app;

import com.cdk.shopperstop.pojo.Customer;
import com.cdk.shopperstop.pojo.CustomerBill;
import com.cdk.shopperstop.service.CustomerBillService;
import com.cdk.shopperstop.service.CustomerBillServiceImpl;

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
			billService.generateBill(cb);
			System.out.println("The Final bill after discount ::" + cb.getFinalBill());
		} catch (NumberFormatException e) {
			System.out.println("Proper number syntax have to be used.");
			throw e;
		} catch (NullPointerException e) {
			e.getMessage();
			throw e;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Please make sure that the parameters are passed both bill and Typeofcustomer");
			e.getMessage();
			throw e;
		} catch (IllegalArgumentException e) {
			e.getMessage();
			throw e;
		}

	}
}
