package fhcampuswien.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column
    private String question;

    @Lob
    @Column(length = 1000)
    private byte[] image;

    @ElementCollection
    @CollectionTable(name="listOfAnswers")
    private List<String> possibleAnswers = new ArrayList<>();

    @Column
    private String rightAnswer;
}
