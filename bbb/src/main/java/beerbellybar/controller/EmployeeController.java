package beerbellybar.controller;


import beerbellybar.business.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/admin-login")
    public String getLoginView() {
        return "admin-login.html";
    }

    @GetMapping("/admin-dashboard")
    public String getAdninDashboard() {
        return "admin-dashboard.html";
    }












}
