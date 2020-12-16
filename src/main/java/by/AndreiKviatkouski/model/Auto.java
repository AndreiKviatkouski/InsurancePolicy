package by.AndreiKviatkouski.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "client_auto")
public class Auto {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    @Pattern(regexp= "^[A-Z][0-9][A-Z][0-9][A-Z][0-9]$",message = "A1B2C3")
    private String vin;

    @Pattern(regexp= "^[A-Z]{1,3}[a-z]{1,10}$",message = "VW or Volvo")
    private String brand;

    @Pattern(regexp= "^[0-9]{1,3}$",message = "95")
    private String power;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Past
    private LocalDate releaseDate;

    @OneToOne
    VehicleCertificate vehicleCertificate;
}
