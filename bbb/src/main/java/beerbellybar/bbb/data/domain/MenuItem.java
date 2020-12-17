package beerbellybar.bbb.data.domain;


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

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public Double getPrice() {return price;}

    public void setPrice(Double price) {this.price = price;}

    public Order getOrder() {return order;}

    public void setOrder(Order order) {this.order = order;}
}