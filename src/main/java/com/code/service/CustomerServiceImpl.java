package com.code.service;

import com.code.dto.request.customer.CustomerRequest;
import com.code.dto.response.customer.CustomerResponse;
import com.code.errors.ApplicationException;
import com.code.errors.Errors;
import com.code.model.Customer;
import com.code.model.Wallet;
import com.code.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    @Override
    public CustomerResponse createNewSignUp(CustomerRequest customerRequest) {

        Optional<Customer> customer = customerRepository.findByMobileNo (customerRequest.getMobileNo ());
        if (customer.isPresent ()) {
            throw new ApplicationException (Errors.USER_EXISTS);
        }

        Customer customerForSave = Customer.builder ()
                .userName (customerRequest.getUserName ())
                .email (customerRequest.getEmail ())
                .mobileNo (customerRequest.getMobileNo ())
                .password (customerRequest.getPassword ())
                .build ();
        customerRepository.save (customerForSave);

        return CustomerResponse.builder ()
                .message (String.format ("User registered successfully: %s", customerForSave.getMobileNo ()))
                .build ();
    }

    @Override
    public CustomerResponse updateSignUpDetails(String mobileNo, CustomerRequest signUp) {
        customerRepository.findByMobileNo (mobileNo)
                .orElseThrow (() -> new ApplicationException (Errors.USER_NOT_FOUND));

        Customer customerForUpdate = modelMapper.map (signUp, Customer.class);
        customerForUpdate.setPassword (signUp.getPassword ());
        customerForUpdate.setUserName (signUp.getUserName ());

        Customer savedCustomer = customerRepository.save (customerForUpdate);
        return modelMapper.map (savedCustomer, CustomerResponse.class);
    }
}
