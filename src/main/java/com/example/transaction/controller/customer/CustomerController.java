package com.example.transaction.controller.customer;

import com.example.transaction.model.customer.Customer;
import com.example.transaction.service.customerService.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/save")

    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        Customer saveCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.ok(saveCustomer);
    }
}
