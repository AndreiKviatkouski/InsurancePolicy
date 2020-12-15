package by.AndreiKviatkouski.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
@Table(name = "client_address")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp= "^[A-Z][a-z]{1,20}$",message = "Example: Minsk")
    private String city;

    @Pattern(regexp= "^[A-Z][a-z]{1,20}$",message = "Example: Platonova")
    private String street;

    @Pattern(regexp= "^[0-9]{1,4}$",message = "Example: 10")
    private int home;

    @Pattern(regexp= "^[0-9]{1,4}$",message = "Example: 159")
    private int flat;
}
