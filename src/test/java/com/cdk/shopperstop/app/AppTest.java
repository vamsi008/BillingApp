package com.cdk.shopperstop.app;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test(expected = NullPointerException.class)
	public void testApp() {

		String[] inputs = new String[3];
		App.main(inputs);
		inputs[1]="premium";
		App.main(inputs);

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAppParams() {
		String[] inputs = new String[0];
		inputs[0] = "1000";
		App.main(inputs);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAppParamsBill() {

		String[] inputs = new String[3];
		inputs[0] = "-1";
		inputs[1] = "premium";
		App.main(inputs);

	}

}
