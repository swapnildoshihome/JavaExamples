import javax.swing.*;

public class CalculatorExample {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setSize(250, 280);
        calculator.setResizable(false);
        calculator.setVisible(true);
    }
}
