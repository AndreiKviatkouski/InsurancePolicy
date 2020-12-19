package by.AndreiKviatkouski.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Table(name = "client")
@Proxy(lazy = false)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Pattern(regexp = "^[A-Z][a-z]{1,10}$", message = "Example: Bob")
    private String firstName;


    @Pattern(regexp = "^[A-Z][a-z]{1,10}$", message = "Example: Li")
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Past
    private LocalDate birthDay;

    @Email
    private String email;


    @Pattern(regexp = "^\\+?375[\\(]?\\d{2}\\)?-?\\d{3}-?\\d{2}-?\\d{2}$", message = "Example:+375(XX)-XXX-XX-XX or +375XXXXXXXXX")
    private String phone;

    @OneToOne(cascade = {CascadeType.ALL})
    Passport passport;

    @OneToOne(cascade = {CascadeType.ALL})
    Address address;


    @Pattern(regexp = "^[0-9]{1,2}$", message = "Example: 5 ")
    private String drivingExperience;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
