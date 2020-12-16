package by.AndreiKviatkouski.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Table(name = "client_passport")

public class Passport {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)

    private  long id;
    @Pattern(regexp = "^[A-Z]{2}[0-9]{1,6}$", message = "Example: AA123456 ")
    String seriesAndNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Past
    LocalDate registrationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(seriesAndNumber, passport.seriesAndNumber) &&
                Objects.equals(registrationDate, passport.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriesAndNumber, registrationDate);
    }
}
