import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Calculator extends JFrame {
    final JButton[] buttons = {
            new JButton("7"),
            new JButton("8"),
            new JButton("9"),
            new JButton("+"),
            new JButton("4"),
            new JButton("5"),
            new JButton("6"),
            new JButton("-"),
            new JButton("1"),
            new JButton("2"),
            new JButton("3"),
            new JButton("*"),
            new JButton("Cls"),
            new JButton("0"),
            new JButton("="),
            new JButton("/")
    };
    JLabel displayedResult;
    JPanel bpanel;
    String operator;
    Double num1 = 0.0, num2 = 0.0, result = 0.0;

    public Calculator() {
        super("Calculator");

        displayedResult = new JLabel("0000");
        displayedResult.setFont(new Font("New Font", Font.PLAIN, 40));
        displayedResult.setHorizontalAlignment(JLabel.RIGHT);
        add(displayedResult, BorderLayout.NORTH);

        bpanel = new JPanel();
        EventHandler handler = new EventHandler();
        KeyEventHandle keyhandler = new KeyEventHandle();

        for (JButton b : buttons) {
            b.addActionListener(handler);
            b.addKeyListener(keyhandler);
            bpanel.add(b);
        }

        GridLayout layout1 = new GridLayout(4, 4, 5, 5);
        bpanel.setLayout(layout1);
        add(bpanel, BorderLayout.CENTER);

    }

    private void numKeys(String num) {
        double number = Double.parseDouble(num);
        double newResult = Double.parseDouble(displayedResult.getText()) * 10;
        newResult += number;
        displayedResult.setText(String.valueOf(newResult));
    }

    private void opeKeys(String opt) {

        if (opt.equals("=")) {
            num2 = Double.parseDouble(displayedResult.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }

            displayedResult.setText(result.toString());
        } else {
            operator = opt;
            num1 = Double.parseDouble(displayedResult.getText());
            displayedResult.setText("0000");
        }

    }

    class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String input = e.getActionCommand();

            if (input.matches("\\d")) {
                numKeys(input);
            } else {
                opeKeys(input);
            }
        }

    }

    private class KeyEventHandle implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

            String typedKey = String.valueOf(e.getKeyChar());

            if (typedKey.matches("\\d")) {
                numKeys(typedKey);
            } else if (typedKey.matches("\\+|-|\\*|/|=")) {
                opeKeys(typedKey);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}