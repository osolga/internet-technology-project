package beerbellybar.process.bbb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/reservation")
public class ReservationController {

    @GetMapping
    public String getReservationView() {
        return "cus-reservations.html";
    }

    @GetMapping("/create")
    public String getReservationCreateView() {
        return "reservation-create.html";
    }
}
