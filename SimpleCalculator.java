import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {

    private TextField num1Field;
    private TextField num2Field;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
       
        num1Field = new TextField();
        num1Field.setPromptText("Enter first number");
        num2Field = new TextField();
        num2Field.setPromptText("Enter second number");

        
        Button addButton = new Button("(+)ADDITION");
        addButton.setOnAction(e -> calculate('+'));
        addButton.setStyle("-fx-background-color: #0000FF; -fx-text-fill: white;");
        Button subtractButton = new Button("(-)SUBTRACTION");
        subtractButton.setOnAction(e -> calculate('-'));
        subtractButton.setStyle("-fx-background-color: #CC0303; -fx-text-fill: white;");
        Button multiplyButton = new Button("(*)MULTIPLICATION");
        multiplyButton.setOnAction(e -> calculate('*'));
        multiplyButton.setStyle("-fx-background-color: #15CC03; -fx-text-fill: white;");
        Button divideButton = new Button("(/)DIVISION");
        divideButton.setOnAction(e -> calculate('/'));

        
        resultLabel = new Label();

        
        VBox vbox = new VBox(10); 
        vbox.setAlignment(Pos.CENTER_LEFT); 
        vbox.setPadding(new Insets(20)); 
        vbox.getChildren().addAll(num1Field, num2Field, addButton, subtractButton, multiplyButton, divideButton, resultLabel);

        
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.show();
    }

    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0)
                        result = num1 / num2;
                    else
                        throw new ArithmeticException("Mathematical ERROR!");
                    break;
            }
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
        } catch (ArithmeticException e) {
            resultLabel.setText(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
