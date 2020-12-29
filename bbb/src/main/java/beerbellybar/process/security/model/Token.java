package beerbellybar.process.security.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Token {
    @Id
    private String token;

    public Token() {}

    public Token(String token) {
        this.token = token;
    }
}
