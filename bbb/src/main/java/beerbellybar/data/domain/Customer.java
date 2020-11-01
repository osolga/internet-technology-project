package beerbellybar.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty(message = "Please provide a name.")
    private String name;
    @Email(message = "Please provide a valid e-mail.")
    @NotEmpty(message = "Please provide an e-mail.")
    private String email;
    private String mobile;
    private String address;
    @org.springframework.data.annotation.Transient //will not be serialized
    private String password;
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Bills> bills;
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Reservation> reservation;

    public Long getId() {return id;}

    public void setID(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getMobile() {return mobile;}

    public void setMobile(String mobile) {this.mobile = mobile;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getPassword() {
        String transientPassword = this.password;
        this.password = null;
        return transientPassword;
    }

    public void setPassword(String password) {this.password = password;}

    public List<Bills> getBills() {return bills;}

    public void setBills(List<Bills> bills) {this.bills = bills;}

    public List<Reservation> getReservation() {return reservation;}

    public void setReservation(List<Reservation> reservation) {this.reservation = reservation;}
}
