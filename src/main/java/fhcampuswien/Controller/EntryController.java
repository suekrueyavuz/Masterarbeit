package fhcampuswien.Controller;

import fhcampuswien.Enum.Meal;
import fhcampuswien.Entity.Entry;
import fhcampuswien.Entity.Food;
import fhcampuswien.Service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class EntryController {
    private EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @PostMapping("/entry")
    public ResponseEntity<Entry> addFoodToEntry(@RequestBody Food food,
                          @RequestParam int amount,
                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                          @RequestParam Meal meal) {
        for(int i=0; i<amount; i++) {
            entryService.addFoodToEntry(date, food, meal);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/entry")
    public ResponseEntity<Entry> removeFoodFromEntry(@RequestParam String foodName,
                                                     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                                     @RequestParam Meal meal) {
        return new ResponseEntity<>(entryService.removeFoodFromEntry(date, foodName, meal), HttpStatus.OK);
    }

    @GetMapping("/entry")
    public ResponseEntity<Entry> getEntry(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Entry entry = entryService.findByDate(date);
//        if(entry == null) {
//            entry = new Entry();
//        }
        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

}
