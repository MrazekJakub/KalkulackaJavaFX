package com.example.kalkulackakterasnadbudefungovat;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Platform;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloController{
    @FXML
    private TextField displej;

    private double operand = 0;
    private String operator = "";

    @FXML
    void pressCislo(javafx.event.ActionEvent event) {
        Button btn = (Button) event.getSource();
        if (displej.getText().equals("0")) {
            displej.setText(btn.getText());
        } else {
            displej.setText(displej.getText() + btn.getText());
        }
    }
    @FXML
    void operace(javafx.event.ActionEvent event) {
        Button btn = (Button) event.getSource();
        operator = btn.getText();
        operand = Double.parseDouble(displej.getText());
        displej.setText("0");
    }
    @FXML
    void rovno(javafx.event.ActionEvent event) {
        if (operator.isEmpty()) {
            return; // Nebyla zadána žádná operace
        }
        String displejText = displej.getText();
        if (displejText.isEmpty()) {
            return; // Displej je prázdný
        }
        double secondOperand = Double.valueOf(displejText);
        double result = 0;
        switch (operator) {
            case "+":
                result = operand + secondOperand;
                break;
            case "-":
                result = operand - secondOperand;
                break;
            case "*":
                result = operand * secondOperand;
                break;
            case "/":
                if (secondOperand != 0) {
                    result = operand / secondOperand;
                } else {
                    displej.setText("Chyba");
                    return; // přidat procento pro úpravu
                }
                break;
        }
        displej.setText(String.valueOf(result));
        operator = "";
        operand = result;
    }
    @FXML
    void metadaC(javafx.event.ActionEvent event) {
        displej.setText("0");
        operand = 0;
        operator = "";
    }
    @FXML
    void metadaCE(javafx.event.ActionEvent event) {
        displej.setText("0");
    }
    @FXML
    void tecka(javafx.event.ActionEvent event) {
        String tmp = displej.getText();
        if (!tmp.contains(".")) {
            displej.setText(tmp + ".");
        }
    }
    // Metoda pro výpočet faktoriálu (poznamenej, že faktoriál se bude počítat jen pro celá čísla)
    @FXML
    void ix(javafx.event.ActionEvent event) {
        String tmp = displej.getText();
        if (tmp.indexOf(".") != -1) {
            // faktoriál není definován pro desetinná čísla
            displej.setText("Chyba");
            return;
        }
        long num = Long.parseLong(tmp);
        displej.setText(String.valueOf(factorial(num)));
    }
    long factorial(int num) {
        if (num > 1) {
            return num * factorial(num - 1);
        } else {
            return 1;
        }
    }
    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }
    public void down(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Button) mouseEvent.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
    private long factorial(long num) {
        if (num > 1) {
            return num * factorial(num - 1);
        } else {
            return 1;
        }
    }

}