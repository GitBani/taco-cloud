package sia.tacocloud;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@RestResource(rel = "orders", path = "orders")
public class TacoOrder implements Serializable {

    private static final long serializedVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private Date placedAt = new Date();

    // Replace these fields with User to bind orders to a user, then the User holds this info
    @Column(nullable = false)
    @NotBlank(message = "Delivery name is required")
    private String deliveryName;

    @Column(nullable = false)
    @NotBlank(message = "Street is required")
    private String deliveryStreet;

    @Column(nullable = false)
    @NotBlank(message = "City is required")
    private String deliveryCity;

    @Column(nullable = false)
    @NotBlank(message = "State is required")
    private String deliveryState;

    @Column(nullable = false)
    @NotBlank(message = "Zip code is required")
    private String deliveryZip;

    @Column(nullable = false)
    @CreditCardNumber(message = "Invalid credit card number")
    private String ccNumber;

    @Column(nullable = false)
    @Pattern(regexp = "^(0[1-9]|1[0-2])/([2-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Column(nullable = false)
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    @Size(min = 1, message = "Must have at least 1 item in your order")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
