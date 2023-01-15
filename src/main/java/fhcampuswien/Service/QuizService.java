package fhcampuswien.Service;

import fhcampuswien.Entity.Quiz;
import fhcampuswien.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class QuizService {
    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public void save(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public List<Quiz> getQuiz() {
        return quizRepository.findAll();
    }
}
