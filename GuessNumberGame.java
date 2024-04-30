import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class GuessNumberGame extends Application {

    private int randomNumber;
    private int attempts;
    private Label resultLabel;
    private Label attemptsLabel;

    @Override
    public void start(Stage primaryStage) {
        
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1; 

        
        attempts = 0;

        
        TextField guessField = new TextField();
        guessField.setText("Enter your guess");

        
        Button guessButton = new Button("Guess");
        guessButton.setOnAction(e -> checkGuess(guessField.getText()));

        
        resultLabel = new Label();
        attemptsLabel = new Label("Attempts: " + attempts);

        
        VBox vbox = new VBox(10); 
        vbox.setAlignment(Pos.CENTER); 
        vbox.setPadding(new Insets(20)); 
        vbox.getChildren().addAll(
               new Label("Guess the number from 1 - 100"),
               guessField, guessButton, resultLabel, attemptsLabel);

        
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Guess the Number Game");
        primaryStage.show();
    }

    private void checkGuess(String guess) {
        try {
            int userGuess = Integer.parseInt(guess);
            attempts++;
            attemptsLabel.setText("Attempts: " + attempts);

            if (userGuess == randomNumber) {
                resultLabel.setText("Congratulations! You guessed the correct number: " + randomNumber);
                resultLabel.setStyle("-fx-text-fill: green;");
            } else if (userGuess < randomNumber) {
                resultLabel.setText("Try a higher number");
                resultLabel.setStyle("-fx-text-fill: red;");
            } else {
                resultLabel.setText("Try a lower number");
                resultLabel.setStyle("-fx-text-fill: red;");
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
