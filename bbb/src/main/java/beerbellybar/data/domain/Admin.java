package beerbellybar.data.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin {

    @Id
    @GeneratedValue
    private Long id;
    @org.springframework.data.annotation.Transient //will not be serialized
    private String password;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getPassword() {
        String transientPassword = this.password;
        this.password = null;
        return transientPassword;
    }

    public void setPassword(String password) {this.password = password;}
}
