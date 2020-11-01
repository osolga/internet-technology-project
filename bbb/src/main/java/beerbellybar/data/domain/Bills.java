package beerbellybar.data.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bills {

    @Id
    @GeneratedValue
    private Long id;
    private Double tab_amount;
    private Double discount;
    private String bill_date_due;
    @OneToMany(mappedBy = "bills")
    @JsonIgnore
    private List<Order> order;
    @OneToOne
    @JsonIgnore
    private Admin admin;
    @ManyToOne
    @JsonIgnore
    private Customer customer;

    //getters and setter still due
}
