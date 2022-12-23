package fhcampuswien.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Food implements Serializable {
    private String food_name;
    private double calorie;
    private double carbohydrate;
    private double protein;
    private double fat;
}
