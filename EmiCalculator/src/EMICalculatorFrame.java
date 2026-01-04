import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class EMICalculatorFrame extends JFrame {
    private JTextField loanAmountField;
    private JTextField interestRateField;
    private JTextField tenureField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public EMICalculatorFrame() {
        setTitle("EMI Calculator");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildUI();
        setVisible(true);
    }

    private void buildUI() {
        JLabel loanLabel = new JLabel("Loan Amount:");
        loanLabel.setBounds(20, 20, 120, 25);
        add(loanLabel);

        loanAmountField = new JTextField();
        loanAmountField.setBounds(150, 20, 150, 25);
        add(loanAmountField);

        JLabel interestLabel = new JLabel("Interest Rate (% p.a.):");
        interestLabel.setBounds(20, 60, 150, 25);
        add(interestLabel);

        interestRateField = new JTextField();
        interestRateField.setBounds(150, 60, 150, 25);
        add(interestRateField);

        JLabel tenureLabel = new JLabel("Tenure (months):");
        tenureLabel.setBounds(20, 100, 150, 25);
        add(tenureLabel);

        tenureField = new JTextField();
        tenureField.setBounds(150, 100, 150, 25);
        add(tenureField);

        calculateButton = new JButton("Calculate EMI");
        calculateButton.setBounds(120, 140, 150, 30);
        add(calculateButton);

        resultLabel = new JLabel("EMI: ");
        resultLabel.setBounds(20, 190, 350, 25);
        add(resultLabel);

        // Button click event
        calculateButton.addActionListener(e -> calculateEMI());
    }

    private void calculateEMI() {
        try {
            double principal = Double.parseDouble(loanAmountField.getText());
            double annualRate = Double.parseDouble(interestRateField.getText());
            int months = Integer.parseInt(tenureField.getText());

            double monthlyRate = annualRate / (12 * 100); // convert annual % to monthly decimal
            double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                         (Math.pow(1 + monthlyRate, months) - 1);

            DecimalFormat df = new DecimalFormat("#.##");
            resultLabel.setText("EMI: ₹ " + df.format(emi));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        new EMICalculatorFrame();
    }
}
