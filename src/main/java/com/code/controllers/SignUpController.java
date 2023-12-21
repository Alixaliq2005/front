package com.code.controllers;


import com.code.dto.request.customer.CustomerRequest;
import com.code.dto.response.customer.CustomerResponse;
import com.code.model.Customer;
import com.code.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class SignUpController {

    private final CustomerService signUpService;

    // Endpoint for handling user signup requests.
// Processes the signup request based on the provided `customerRequest` parameter and
// returns the result in the ResponseEntity format.
    @PostMapping("/signUp")
    public ResponseEntity<CustomerResponse> createNewSignUpHandler(@RequestBody CustomerRequest customerRequest) {
        // Returns the result of the signup operation performed in the SignUpService using ResponseEntity.ok.
        return ResponseEntity.ok(signUpService.createNewSignUp(customerRequest));
    }

    // Endpoint for handling user signup details update requests.
// Processes the signup details update request based on the provided `mobileNo` and
// `signUp` parameters and returns the result in the ResponseEntity format.
    @PutMapping("/{mobileNo}/signUp/update")
    public ResponseEntity<CustomerResponse> updateSignUpDetailsHandler(@PathVariable String mobileNo,
                                                                       @RequestBody CustomerRequest signUp) {
        // Returns the result of the signup details update operation performed in the SignUpService using ResponseEntity.ok.
        return ResponseEntity.ok(signUpService.updateSignUpDetails(mobileNo, signUp));
    }

}




