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

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Double getTab_amount() {return tab_amount;}

    public void setTab_amount(Double tab_amount) {this.tab_amount = tab_amount;}

    public Double getDiscount() {return discount;}

    public void setDiscount(Double discount) {this.discount = discount;}

    public List<Order> getOrder() {return order;}

    public void setOrder(List<Order> order) {this.order = order;}

    public Admin getAdmin() {return admin;}

    public void setAdmin(Admin admin) {this.admin = admin;}

    public Customer getCustomer() {return customer;}

    public void setCustomer(Customer customer) {this.customer = customer;}
}
