import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberChecker extends JFrame {
    private JTextField numberField;
    private JTextArea resultArea;

    public NumberChecker() {
        setTitle("Number Property Checker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Enter a Number:"));
        numberField = new JTextField(15);
        add(numberField);

        JButton checkButton = new JButton("Check Properties");
        add(checkButton);

        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(numberField.getText());
                    checkNumber(num);
                } catch (NumberFormatException ex) {
                    resultArea.setText("Invalid Input! Please enter a valid integer.");
                }
            }
        });

        setVisible(true);
    }

    private void checkNumber(int num) {
        StringBuilder result = new StringBuilder();
        result.append("Number: ").append(num).append("\n");
        result.append("Even/Odd: ").append(num % 2 == 0 ? "Even" : "Odd").append("\n");
        result.append("Prime: ").append(isPrime(num) ? "Yes" : "No").append("\n");
        result.append("Palindrome: ").append(isPalindrome(num) ? "Yes" : "No").append("\n");
        result.append("Armstrong: ").append(isArmstrong(num) ? "Yes" : "No").append("\n");
        resultArea.setText(result.toString());
    }

    private boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private boolean isArmstrong(int n) {
        int original = n, sum = 0, digits = String.valueOf(n).length();
        while (n > 0) {
            sum += Math.pow(n % 10, digits);
            n /= 10;
        }
        return sum == original;
    }

    public static void main(String[] args) {
        new NumberChecker();
    }
}
