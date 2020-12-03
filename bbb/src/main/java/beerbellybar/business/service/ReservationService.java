package beerbellybar.business.service;

import beerbellybar.data.domain.Reservation;
import beerbellybar.data.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CustomerService customerService;

    @Autowired


    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    public Reservation editReservation(@Valid Reservation reservation) throws Exception {
        if (reservation.getId() == null) {
            if (reservationRepository.findByIdNotInReservationAndReservationTime(reservation.getBarTable()) == null) {
                reservation.setCustomer(customerService.getCurrentCustomer());
                return reservationRepository.save(reservation);
            }
        }
    }

    public Reservation findReservationById(Long reservationId) throws Exception {
        List<Reservation> reservationList = reservationRepository.findByIdAndCustomerId(reservationId, customerService.getCurrentCustomer().getId());
        if(reservationList.isEmpty()) {
            throw new Exception("No reservation with ID " + reservationId + " found");
        }
        return reservationList.get(0);
    }

    public List<Reservation> findAllReservations() {
        return reservationRepository.findByCustomerId(customerService.getCurrentCustomer().getId());
    }








}
