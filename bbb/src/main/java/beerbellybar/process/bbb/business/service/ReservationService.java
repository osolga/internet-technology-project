package beerbellybar.process.bbb.business.service;

import beerbellybar.process.bbb.data.domain.BarTable;
import beerbellybar.process.bbb.data.domain.Reservation;
import beerbellybar.process.bbb.data.repository.BarTableRepository;
import beerbellybar.process.bbb.data.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
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
    private BarTableRepository barTableRepository;

    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    public Reservation editReservation(@Valid Reservation reservation) throws Exception {
        if (reservation.getId() == null) {
            if (reservationRepository.findByReservationTimeAndCustomerId(reservation.getReservationTime(), customerService.getCurrentCustomer().getId()) == null) {
                reservation.setCustomer(customerService.getCurrentCustomer());
                if (barTableRepository.findByReservationReservationTimeNot(reservation.getReservationTime()) != null) {
                    reservation.setBarTable(barTableRepository.findByReservationReservationTimeNot(reservation.getReservationTime()).get(0));
                    return reservationRepository.save(reservation);
                }
                throw new Exception("Reservation not possible there are no free tables this day.");
            }
            throw new Exception("Reservation not possible you already have a reservation that day.");
        }
        throw new Exception("Reservation not possible there are no free tables.");
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

    @PostConstruct
    private void initTables () {
        barTableRepository.save(new BarTable());
        barTableRepository.save(new BarTable());
        barTableRepository.save(new BarTable());
        barTableRepository.save(new BarTable());
        barTableRepository.save(new BarTable());
    }
}
