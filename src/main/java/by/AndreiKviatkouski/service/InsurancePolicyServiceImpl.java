package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.model.InsurancePolicy;
import by.AndreiKviatkouski.model.Policy;
import by.AndreiKviatkouski.repository.InsurancePolicyRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {


    private final InsurancePolicyRepository insurancePolicyRepository;

    public InsurancePolicyServiceImpl(InsurancePolicyRepository policyRepository) {
        this.insurancePolicyRepository = policyRepository;
    }


    @Override
    public void createCASCO(InsurancePolicy insurancePolicy) {
        if (insurancePolicyRepository.existsInsurancePolicyByClientPassport(insurancePolicy.getClient().getPassport())) {

            BigDecimal insuranceRate = new BigDecimal(1000)
                    .setScale(2, RoundingMode.DOWN);

            BigDecimal drivingExperience = new BigDecimal(insurancePolicy.getClient().getDrivingExperience());

            BigDecimal powerCar = new BigDecimal(insurancePolicy.getAuto().getPower());

            insurancePolicy.setPrice((insuranceRate.subtract(drivingExperience).add(powerCar)));

            insurancePolicy.setPolicy(Policy.CASCO);
            insurancePolicyRepository.save(insurancePolicy);
        }

    }

    @Override
    public void createOSAGO(InsurancePolicy insurancePolicy) {
        if (insurancePolicyRepository.existsInsurancePolicyByClientPassport(insurancePolicy.getClient().getPassport())) {
            BigDecimal insuranceRate = new BigDecimal(40)
                    .setScale(2, RoundingMode.DOWN);

            BigDecimal drivingExperience = new BigDecimal(insurancePolicy.getClient().getDrivingExperience());

            insurancePolicy.setPrice((insuranceRate.subtract(drivingExperience)).multiply(BigDecimal.valueOf(1.2)));

            insurancePolicy.setPolicy(Policy.CASCO);
            insurancePolicyRepository.save(insurancePolicy);
        }
    }

    @Override
    public List<InsurancePolicy> getAll() {
        return insurancePolicyRepository.findAll();
    }

    @Override
    public InsurancePolicy getById(long id) {
        return insurancePolicyRepository.getOne(id);
    }

    @Override
    public boolean updateById(InsurancePolicy insurancePolicy, long id) {

        if (insurancePolicyRepository.existsById(id)) {
            insurancePolicy.setId(id);
            insurancePolicyRepository.save(insurancePolicy);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteById(long id) {
        if (insurancePolicyRepository.existsById(id)) {
            insurancePolicyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
