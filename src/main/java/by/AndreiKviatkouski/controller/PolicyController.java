package by.AndreiKviatkouski.controller;

import by.AndreiKviatkouski.model.InsurancePolicy;
import by.AndreiKviatkouski.service.InsurancePolicyServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PolicyController {

    private final InsurancePolicyServiceImpl insurancePolicyService;

    public PolicyController(InsurancePolicyServiceImpl insurancePolicyService) {
        this.insurancePolicyService = insurancePolicyService;
    }


    @PostMapping(value = "/forms/casco",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<?> createCASCO(@Valid @RequestBody InsurancePolicy insurancePolicy) {
        insurancePolicyService.createCASCO(insurancePolicy);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/forms/osago",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<?> createOSAGO(@Valid @RequestBody InsurancePolicy insurancePolicy) {
        insurancePolicyService.createOSAGO(insurancePolicy);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/forms",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<List<InsurancePolicy>> getAll() {
        final List<InsurancePolicy> insurancePolicies = insurancePolicyService.getAll();

        return insurancePolicies != null && !insurancePolicies.isEmpty()
                ? new ResponseEntity<>(insurancePolicies, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/forms/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<InsurancePolicy> getById(@Valid @PathVariable(name = "id") int id) {
        final InsurancePolicy insurancePolicy = insurancePolicyService.getById(id);

        return insurancePolicy != null
                ? new ResponseEntity<>(insurancePolicy, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/forms/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<?> updateById(@Valid @PathVariable(name = "id") int id, @RequestBody InsurancePolicy insurancePolicy) {
        final boolean updated = insurancePolicyService.updateById(insurancePolicy, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/forms/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<?> deleteById(@Valid @PathVariable(name = "id") int id) {
        final boolean deleted = insurancePolicyService.deleteById(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
