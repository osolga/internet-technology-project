package beerbellybar.bbb.data.domain;


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

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getOrderTime() {return orderTime;}

    public void setOrderTime(String orderTime) {this.orderTime = orderTime;}

    public List<MenuItem> getMenuItems() {return menuItems;}

    public void setMenuItems(List<MenuItem> menuItems) {this.menuItems = menuItems;}
}