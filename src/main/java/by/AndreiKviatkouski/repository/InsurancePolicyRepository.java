package by.AndreiKviatkouski.repository;

import by.AndreiKviatkouski.model.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {
}
