package com.example.transaction.service.impl.customerImpl;

import com.example.transaction.model.customer.Customer;
import com.example.transaction.repository.customer.CustomerRepository;
import com.example.transaction.service.customerService.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
