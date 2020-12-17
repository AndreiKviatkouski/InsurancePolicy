package by.AndreiKviatkouski.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "client_passport")
@EqualsAndHashCode(exclude = { "id"})
public class Passport {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private  long id;

    @Pattern(regexp = "^[A-Z]{2}[0-9]{1,6}$", message = "Example: AA123456 ")
    String seriesAndNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Past
    LocalDate registrationDate;
}
