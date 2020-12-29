package beerbellybar.process.bbb.controller;


import beerbellybar.process.bbb.business.service.CustomerService;
import beerbellybar.process.bbb.data.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/login")
    public String getLoginView() {
        return "customer-login-register.html";
    }

    @PostMapping("/login")
    public ResponseEntity<Void> postRegister(@RequestBody Customer customer) {
        try {
            customerService.saveCustomer(customer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/profile")
    public  @ResponseBody Customer getProfile() {
        return customerService.getCurrentCustomer();
    }

    @GetMapping("/profile/edit")
    public String getProfileEditView() {
        return "cus-editprofile.html";
    }

    @PutMapping("/profile")
    public ResponseEntity<Void> putProfile(@RequestBody Customer customer) {
        try {
            customer.setId(customerService.getCurrentCustomer().getId());
            customerService.saveCustomer(customer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }


}