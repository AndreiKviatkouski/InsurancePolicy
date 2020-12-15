package by.AndreiKviatkouski.controller;

import by.AndreiKviatkouski.model.Policy;
import by.AndreiKviatkouski.service.InsurancePolicyServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PolicyController {

    private final InsurancePolicyServiceImpl insurancePolicyService;

    public PolicyController(InsurancePolicyServiceImpl insurancePolicyService) {
        this.insurancePolicyService = insurancePolicyService;
    }


    @PostMapping(value = "/forms")
    public ResponseEntity<?> create(@RequestBody Policy policy) {
        insurancePolicyService.create(policy);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/forms")
    public ResponseEntity<List<Policy>> getAll() {
        final List<Policy> policies = insurancePolicyService.getAll();

        return policies != null && !policies.isEmpty()
                ? new ResponseEntity<>(policies, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/forms/{id}")
    public ResponseEntity<Policy> getById(@PathVariable(name = "id") int id) {
        final Policy policy = insurancePolicyService.getById(id);

        return policy != null
                ? new ResponseEntity<>(policy, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/forms/{id}")
    public ResponseEntity<?> updateById(@PathVariable(name = "id") int id, @RequestBody Policy policy) {
        final boolean updated = insurancePolicyService.updateById(policy, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/forms/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") int id) {
        final boolean deleted = insurancePolicyService.deleteById(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
