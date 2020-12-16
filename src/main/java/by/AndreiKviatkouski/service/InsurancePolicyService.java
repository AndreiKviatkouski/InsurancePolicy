package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.model.InsurancePolicy;

import java.util.List;

public interface InsurancePolicyService {

    void createCASCO(InsurancePolicy insurancePolicy);
    void createOSAGO(InsurancePolicy insurancePolicy);

    List<InsurancePolicy> getAll();

    InsurancePolicy getById(long id);

    boolean updateById(InsurancePolicy insurancePolicy, long id);

    boolean deleteById(long id);
}
