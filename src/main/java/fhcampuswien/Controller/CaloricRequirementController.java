package fhcampuswien.Controller;

import fhcampuswien.Entity.CaloricRequirement;
import fhcampuswien.Service.CaloricRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaloricRequirementController {
    private CaloricRequirementService caloricRequirementService;

    @Autowired
    public CaloricRequirementController(CaloricRequirementService caloricRequirementService) {
        this.caloricRequirementService = caloricRequirementService;
    }

    @PostMapping("/caloricRequirement")
    public ResponseEntity<Double> getCaloricRequirement(@RequestBody CaloricRequirement caloricRequirement) {
        Double result = caloricRequirementService.getCaloricRequirement(caloricRequirement);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
