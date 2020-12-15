package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.model.Policy;
import by.AndreiKviatkouski.repository.InsurancePolicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

    private final InsurancePolicyRepository policyRepository;

    public InsurancePolicyServiceImpl(InsurancePolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }


    @Override
    public void create(Policy policy) {
//        switch (policy) {
//            case Policy.CASCO:
//                //TODO: set price
//                break;
//            case Policy.OSAGO:
//                //TODO: set price 2
//                break;
//        }
//        //TODO; save in repo
    }

    @Override
    public List<Policy> getAll() {
        return null;
    }

    @Override
    public Policy getById(int id) {
        return null;
    }

    @Override
    public boolean updateById(Policy policy, int id) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
