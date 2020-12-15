package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.model.Client;
import by.AndreiKviatkouski.model.Policy;

import java.util.List;

public interface InsurancePolicyService {
    void create(Policy policy);

    List<Policy> getAll();

    Policy getById(int id);

    boolean updateById(Policy policy, int id);

    boolean deleteById(int id);
}
