package fhcampuswien.Repository;

import fhcampuswien.Entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    Optional<Entry> findByDate(LocalDate date);
}
