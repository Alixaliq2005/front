package com.code.controllers;

import com.code.dto.request.billPayment.BillPaymentRequest;
import com.code.dto.response.billPayment.BillPaymentResponse;
import com.code.service.BillPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/billPayment")
public class BillPaymentController {

    private final BillPaymentService billPaymentService;

    // Endpoint for adding a new bill payment operation.
// Processes the bill payment operation based on the provided `customerId` and `billPayment` parameters
// and returns the result in the ResponseEntity format.
    @PostMapping("/{customerId}/post")
    public ResponseEntity<BillPaymentResponse> addNewBillPaymentDetails(@PathVariable Long customerId,
                                                                        @RequestBody BillPaymentRequest billPayment) {
        // Returns the result of the bill payment operation performed in the BillPaymentService using ResponseEntity.ok.
        return ResponseEntity.ok (billPaymentService.makeBillPayment (customerId, billPayment));
    }

    // Endpoint for viewing all bill payments based on a predefined `billId`.
// Retrieves information from the BillPaymentService based on the provided `billId` and,
// optionally, the `paymentRequest` parameters.
    @GetMapping("/{billId}")
    public ResponseEntity<BillPaymentResponse> viewAllBillPayments(@PathVariable Long billId,
                                                                   @RequestBody BillPaymentRequest paymentRequest) {
        // Returns the information obtained from the BillPaymentService using ResponseEntity.ok.
        return ResponseEntity.ok (billPaymentService.viewBillPayments (billId, paymentRequest));
    }


}
