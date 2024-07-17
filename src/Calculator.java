import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    // Create a frame
    private JFrame frame;

    // Create textfields
    private JTextField textFirstNumber, textSecondNumber, textResult;

    // Store operator and result
    private double num1, num2, result;

    // Create buttons
    private JButton addButton, subButton, mulButton, divButton, modButton, clearButton;

    // Constructor
    public Calculator() {
        // Create a frame
        frame = new JFrame("Calculator");

        // Create text fields
        textFirstNumber = new JTextField();
        textSecondNumber = new JTextField();
        textResult = new JTextField();

        // Create buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        clearButton = new JButton("Clear");

        // Add action listeners to buttons
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        modButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Create a panel
        JPanel panel = new JPanel();

        // Add text fields and buttons to the panel
        panel.add(new JLabel("First Number:"));
        panel.add(textFirstNumber);
        panel.add(new JLabel("Second Number:"));
        panel.add(textSecondNumber);
        panel.add(new JLabel("Result:"));
        panel.add(textResult);

        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(modButton);
        panel.add(clearButton);

        // Set layout of panel
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        // Add panel to frame
        frame.add(panel, BorderLayout.CENTER);

        // Set frame properties
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // If a button is pressed
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            num1 = Double.parseDouble(textFirstNumber.getText());
            num2 = Double.parseDouble(textSecondNumber.getText());

            switch (command) {
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
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textResult.setText("Cannot divide by zero");
                        return;
                    }
                    break;
                case "%":
                    result = num1 % num2;
                    break;
                case "Clear":
                    textFirstNumber.setText("");
                    textSecondNumber.setText("");
                    textResult.setText("");
                    return;
            }

            // Set the result in the result text field
            textResult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            textResult.setText("Invalid input");
        }
    }

    // Main method
    public static void main(String[] args) {
        new Calculator();
    }
}