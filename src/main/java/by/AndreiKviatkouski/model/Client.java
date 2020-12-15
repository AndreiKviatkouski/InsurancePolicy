package by.AndreiKviatkouski.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "client")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Pattern(regexp= "^[A-Z][a-z]{1,6}$",message = "Example: Bob")
    private String firstName;

    @NotBlank
    @Pattern(regexp= "^[A-Z][a-z]{1,10}$",message = "Example: Li")
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Past
    private LocalDate birthDay;

    @Email
    private  String email;

    @Pattern(regexp ="^\\+?375[\\(]?\\d{2}\\)?-?\\d{3}-?\\d{2}-?\\d{2}$",message = "Example:+375(XX)-XXX-XX-XX or +375XXXXXXXXX")
    private String phone;

    @OneToOne
    Passport passport;

    @OneToOne
    Address address;

}
