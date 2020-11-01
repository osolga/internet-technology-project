package beerbellybar.data.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MenuItem {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Double price;
    @ManyToOne
    @JsonIgnore
    private Order order;

    // getters and setters due
}
