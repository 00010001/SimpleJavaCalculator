package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controller {

    private double left;
    private String selectedOperator = "";
    private boolean numberInputting = false;

    @FXML
    private TextField display;

    @FXML
    private void processInput(ActionEvent event) {
        Button button = (Button)event.getSource();
        String buttonText = button.getText();
        if (buttonText.equals("C") || buttonText.equals("AC")) {
            if (buttonText.equals("AC")) {
                left = 0;
            }
            selectedOperator = "";
            numberInputting = false;
            display.setText("0");;
            return;
        }
        if (buttonText.matches("[0-9\\.]")) {
            if (!numberInputting) {
                numberInputting = true;
                display.setText("");
            }
            display.appendText(buttonText);
            return;
        }
        if (buttonText.matches("[+,\\-,*,\\/]")) {
            left = Double.valueOf(display.getText());
            selectedOperator = buttonText;
            display.setText(selectedOperator);

            numberInputting = false;
            return;
        }
        if (buttonText.equals("=")) {
            double right = Double.valueOf(display.getText());
            left = calculate(selectedOperator, left, right);
            display.setText(left+"");
            numberInputting = false;
        }
    }

    private static double calculate(String operator, Double left, Double right) {
        System.out.println(operator);
        if(operator.equals("+")){
             return  (left + right);
        }
        if(operator.equals("-")){
            return  (left - right);
        }
        if(operator.equals("*")){
            return  (left * right);
        }
        if(operator.equals("/")){
            return  (left / right);
        }
        return right;
    }
}
