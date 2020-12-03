package beerbellybar.business.service;

import beerbellybar.data.domain.Reservation;
import beerbellybar.data.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired


    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    public Reservation editReservation(@Valid Reservation reservation) throws Exception {
        if (reservation.getId() == null) {
            if (reservationRepository.findByTable(reservation.getTable()) == null) {
                reservation.setCustomer(customerService.getCurrentCustomer());
                return reservationRepository.save(reservation);
            }
        }
    }









}
