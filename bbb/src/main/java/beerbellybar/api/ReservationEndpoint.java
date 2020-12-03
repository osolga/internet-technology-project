package beerbellybar.api;


import beerbellybar.business.service.ReservationService;
import beerbellybar.data.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.Path;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ReservationEndpoint {

    @Autowired
    private ReservationService reservationService;

    @PostMapping(path = "/reservation", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Reservation> postReservation(@RequestBody Reservation reservation) {
        try {
            reservation = reservationService.editReservation(reservation);
        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getConstraintViolations().iterator().next().getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{reservationId}")
                .buildAndExpand(reservation.getId()).toUri();

        return ResponseEntity.created(location).body(reservation):
    }

    @GetMapping(path = "/reservation", produces =  = "application/json")
    public List<Reservation> getReservation() {
        return  reservationService.findAllCustomers();
    }

    @GetMapping(path = "/reservation/{reservationId}", produces =  = "application/json")
    public ResponseEntity<Reservation> getReservation(@PathVariable(value = "reservationId") String reservationID) {
        Reservation reservation = null;
        try {
            reservation = reservationService.findReservationById(Long.parseLong(reservationId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return ResponseEntity.ok(reservation);
    }

    @PutMapping(path = "/reservation/{reservationId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Reservation> putReservation(@RequestBody Reservation reservation, @PathVariable(value = "reservationId") String reservationId) {
        try {
            reservation.setId(Long.parseLong(reservationId));
            reservation = reservationService.editReservation(reservation);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.accepted().body(reservation);
    }

    @DeleteMapping(path = "/reservation/{reservationId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable(value = "reservationId") String reservationId) {
        try {
            reservationService.deleteReservation(Long.parseLong(reservationId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.accepted().build();
    }
}
