package by.AndreiKviatkouski.repository;

import by.AndreiKviatkouski.model.InsurancePolicy;
import by.AndreiKviatkouski.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {
    boolean existsInsurancePolicyByClientPassport(Passport passport);
}
