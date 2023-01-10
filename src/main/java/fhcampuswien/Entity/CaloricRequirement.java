package fhcampuswien.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaloricRequirement {
    private String gender;
    private int age;
    private double weight;
    private double height;
    private double pal;
}
