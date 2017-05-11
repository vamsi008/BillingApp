package com.cdk.shopperstop.service;

import com.cdk.shopperstop.pojo.CustomerType;

public interface DiscountCalService {

	public Double getFinalPrice(Double billAmount, CustomerType ctype);

}
