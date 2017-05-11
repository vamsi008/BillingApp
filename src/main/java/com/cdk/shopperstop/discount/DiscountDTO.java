package com.cdk.shopperstop.discount;

public class DiscountDTO {
	
	Double upperBound;
	Double lowerBound;
	Double discount;
	
	public DiscountDTO(Double lowerBound,Double upperBound,Double discount){
		this.upperBound=upperBound;
		this.lowerBound=lowerBound;
		this.discount=discount;
		
	}
	public Double getUpperBound() {
		return upperBound;
	}
	public void setUpperBound(Double upperBound) {
		this.upperBound = upperBound;
	}
	public Double getLowerBound() {
		return lowerBound;
	}
	public void setLowerBound(Double lowerBound) {
		this.lowerBound = lowerBound;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	
	

}
