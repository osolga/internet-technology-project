package beerbellybar.data.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class BarTable {

    @Id
    @GeneratedValue
    private Long id;
    private Integer numSeats;
    @OneToMany(mappedBy = "barTable")
    @JsonIgnore
    private List<Reservation> reservation;

    public Long getId() {return id;}

    public void setID(Long id) {this.id = id;}

    public Integer getNumSeats() {return numSeats;}

    public void setNumSeats(Integer numSeats) {this.numSeats = numSeats;}

    public List<Reservation> getReservation() {return reservation;}

    public void setReservation(List<Reservation> reservation) {this.reservation = reservation;}
}
