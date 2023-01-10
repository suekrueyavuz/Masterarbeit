package fhcampuswien.Service;

import fhcampuswien.Entity.CaloricRequirement;
import org.springframework.stereotype.Service;

@Service
public class CaloricRequirementService {

    public Double getCaloricRequirement(CaloricRequirement caloricRequirement) {
        if(caloricRequirement.getGender().equals("Male")) {
            return getCaloricRequirementForMale(caloricRequirement);
        } else if(caloricRequirement.getGender().equals("Female")) {
            return getCaloricRequirementForFemale(caloricRequirement);
        }
        return null;
    }

    private Double getCaloricRequirementForMale(CaloricRequirement caloricRequirement) {
        return (66.5 + (13.75 * caloricRequirement.getWeight()) + (5.003 * caloricRequirement.getHeight()) - (6.75 * caloricRequirement.getAge())) * caloricRequirement.getPal();
    }

    private Double getCaloricRequirementForFemale(CaloricRequirement caloricRequirement) {
        return (655.1 + (9.563 * caloricRequirement.getWeight()) + (1.85 * caloricRequirement.getHeight()) - (4.676 * caloricRequirement.getAge())) * caloricRequirement.getPal();
    }
}
