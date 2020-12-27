package beerbellybar.bbb.business.service;


import beerbellybar.bbb.data.domain.Customer;
import beerbellybar.bbb.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    Validator  validator;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveCustomer(@Valid Customer customer) throws Exception {
        if (customer.getId() == null) {
            if (customerRepository.findByEmail(customer.getEmail()) != null) {
                throw new Exception("Email address " + customer.getEmail() + " already used");
            }
        } else if (customerRepository.findByEmailAndIdNot(customer.getEmail(), customer.getId()) != null) {
            throw new Exception("Email address " + customer.getEmail() + " already used");
        }
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
    }

    public Customer  getCurrentCustomer() {
        String customerEmail = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return customerRepository.findByEmail(customerEmail);
    }
}