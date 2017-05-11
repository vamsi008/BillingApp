# BillingApp

[Problem statement](ProblemStatement.docx)


**Objects**

*CustomerDiscount* :: Object to maintain the discounts.

*Customer* :: Object which preserves the customer type and customer related data.

*CustomerBill*::Bill object which will maintain the customer and relevant original bill and the discounted bill information.

DiscountDTO:: Discount DTO will contain all the information of the discount like upperBound,lowerBound,Discount details.


**Services::**

*CustomerBillService*:: Will provide services related to billing.
*DiscountCalService*:: Will provide services related to Discount.


**Collection**
*DiscountCollection*:: Will contain map of the all the discount Objects related to a customerType.

**Enum**

CustomerType:: Will help distinguish the customerType as "Premium","Regular"




