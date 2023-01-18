package fhcampuswien.Service;

import fhcampuswien.Enum.Meal;
import fhcampuswien.Entity.Entry;
import fhcampuswien.Entity.Food;
import fhcampuswien.Repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
public class EntryService {
    private EntryRepository entryRepository;

    @Autowired
    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public Entry findByDate(LocalDate date) {
        Optional<Entry> entry = entryRepository.findByDate(date);
        return entry.orElse(null);
    }

    public Entry addFoodToEntry(LocalDate date, Food food, Meal meal) {
        Entry entry;

        if(checkIfEntryIsPresent(date)) {
            entry = findByDate(date);
        } else {
            entry = createAndPersistEntry(date);
        }

        if(checkIfMealExists(entry, meal)) {
            entry.getFoods().get(meal).add(food);
        } else {
            entry.getFoods().put(meal, new ArrayList<>(Collections.singletonList(food)));
        }
        return entry;
    }

    public Entry removeFoodFromEntry(LocalDate date, String foodName, Meal meal) {
        Entry entry = findByDate(date);
        if(entry == null) {
            throw new IllegalArgumentException("Entry not found.");
        }

        if(checkIfMealExists(entry, meal)) {
            ArrayList<Food> foods = entry.getFoods().get(meal);
            for(int i=0; i<foods.size(); i++) {
                if(foodName.equals(foods.get(i).getFood_name())) {
                    foods.remove(foods.get(i));
                    break;
                }
            }
        }
        deleteMealIfNoEntries(entry, meal);
        deleteEntryIfNoEntries(entry);
        return entry;
    }

    private void deleteMealIfNoEntries(Entry entry, Meal meal) {
        if(entry.getFoods().get(meal).size() == 0) {
            entry.getFoods().remove(meal);
        }
    }

    private void deleteEntryIfNoEntries(Entry entry) {
        if(entry.getFoods().isEmpty()) {
            entryRepository.delete(entry);
        }
    }

    private boolean checkIfMealExists(Entry entry, Meal meal) {
        return entry.getFoods().containsKey(meal);
    }

    public boolean checkIfEntryIsPresent(LocalDate date) {
        Optional<Entry> entry = entryRepository.findByDate(date);
        return entry.isPresent();
    }

    private Entry createAndPersistEntry(LocalDate date) {
        Entry entry = new Entry();
        entry.setDate(date);
        return entryRepository.save(entry);
    }

}
