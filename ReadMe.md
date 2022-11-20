# LOAN MANAGEMENT SYSTEM
## Description
This is a reactive web application that allows users to subscribe and request for loans.

To subscribe: a customer needs a valid customerNUmber since their KYC must be fetched from the coreBanking.
After Subscription a customer will be able to request a loan.
The loan is the processed in the background by the LoanScheduler class which checks or all NEW loan requests periodically and works on them accordingly  by checking the customer's eligibilty.
The loan status can be checked and it occurs in 3:
- NEW -> Newly submitted request
- PENDING -> In processing
- FAILED -> An error occurred during processing
- REJECTED -> Customer is not eligible for loan maybe because of amount limit or score
- APPROVED -> Customer is eligible for the loan requested.