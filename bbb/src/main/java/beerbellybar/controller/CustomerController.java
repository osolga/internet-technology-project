package beerbellybar.controller;


import beerbellybar.data.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class CustomerController {

    @Autowired
    private CusomerService cusomerService;

    @GetMapping("/login")
    public String getLoginView() {
        return "";
    }

    @GetMapping("/user/register")
    public String getRegisterView() {
        return "sign-up.html";
    }

    @PostMapping("/user/register")
    public ResponseEntity<Void> postRegister(@RequestBody Customer customer) {
        try {
            cusomerService.saveCustomer(customer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/profile")
    public  @ResponseBody Customer getProfile() {
        return cusomerService.getCurrentCustomer();
        return "cus-profile.html";
    }

    @GetMapping("/profile/edit")
    public String getProfileView() {
        return "cus-edit-profile.html";
    }

    @PutMapping("/profile")
    public ResponseEntity<Void> putProfile(@RequestBody Customer customer) {
        try {
            customer.setId(cusomerService.getCurrentCustomer().getId());
            cusomerService.saveCustomer(customer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }


}