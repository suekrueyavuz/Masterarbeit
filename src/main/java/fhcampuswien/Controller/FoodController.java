package fhcampuswien.Controller;

import fhcampuswien.entity.Food;
import fhcampuswien.service.FoodService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class FoodController {
    private FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public ResponseEntity<Food> save(@RequestBody Food food) {
        Food newFood = foodService.save(food);
        return new ResponseEntity<>(newFood, HttpStatus.OK);
    }
}
