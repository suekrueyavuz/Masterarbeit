package fhcampuswien;

import fhcampuswien.Entity.Quiz;
import fhcampuswien.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class MasterarbeitApplication implements CommandLineRunner {
	@Autowired private QuizService quizService;

	public static void main(String[] args) {
		SpringApplication.run(MasterarbeitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		byte[] bytes1 = Files.readAllBytes(Path.of("src/main/resources/images/potatoes.png"));
		byte[] bytes2 = Files.readAllBytes(Path.of("src/main/resources/images/carbohydrates.png"));
		byte[] bytes3 = Files.readAllBytes(Path.of("src/main/resources/images/drinks_overconsumption_consequences.png"));
		byte[] bytes4 = Files.readAllBytes(Path.of("src/main/resources/images/carrots.png"));
		byte[] bytes5 = Files.readAllBytes(Path.of("src/main/resources/images/milk_calcium.png"));
		createQuiz("Which of these is a common source of vitamin A?", bytes1, "Fruits and vegetables particularly carrots",
				"Cheese", "Potatoes especially with the skin", "Fruits and vegetables particularly carrots", "Brewer's yeast");
		createQuiz("What is the primary purpose of making sure your body receives carbohydrates?", bytes2, "To provide the body with energy",
				"To minimise the body's ability to absorb calcium", "To heighten cholesterol levels", "To improve bone marrow", "To provide the body with energy");
		createQuiz("What ill-effect might be caused by the over-consumption of fluids?", bytes3, "Dilution and lowering of sodium levels in the blood",
				"A weakened immune system", "Dilution and lowering of sodium levels in the blood", "Increased conversion to fat", "Aggravated stomach acids");
		createQuiz("How many grams of fibre is it recommended we eat every day?", bytes4, "At least 18",
				"200", "At least 18", "No more than 50", "5-10");
		createQuiz("Which nutrients are especially important for promoting good bone strength?", bytes5, "Calcium and vitamin D",
				"Carbohydrates", "Calcium and vitamin D", "Omega 3", "Iron and sodium");

	}

	private void createQuiz(String question, byte[] image, String rightAnswer, String... possibleAnswers) {
		Quiz quiz = new Quiz();
		quiz.setQuestion(question);
		quiz.setImage(image);
		quiz.setRightAnswer(rightAnswer);
		ArrayList<String> answers = new ArrayList<>();
		Collections.addAll(answers, possibleAnswers);
		quiz.setPossibleAnswers(answers);
		quizService.save(quiz);
	}
}
