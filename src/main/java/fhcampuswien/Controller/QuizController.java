package fhcampuswien.Controller;

import fhcampuswien.Entity.Quiz;
import fhcampuswien.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizController {
    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/quiz")
    public ResponseEntity<List<Quiz>> getQuiz() {
        return new ResponseEntity<>(quizService.getQuiz(), HttpStatus.OK);
    }
}
