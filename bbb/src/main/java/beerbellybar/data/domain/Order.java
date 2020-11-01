package beerbellybar.data.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private String orderTime;
    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<MenuItem> menuItems;

    // getters and setter due
}
