import javax.swing.*;

public class LoginForm extends JFrame {
    private JTextField userText;
    private JPasswordField passText;
    private JButton loginButton;

    public LoginForm() {
        setTitle("Login Form");
        setSize(350, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildUI();
        setVisible(true);
    }

    private void buildUI() {
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 80, 25);
        add(userLabel);

        userText = new JTextField();
        userText.setBounds(120, 20, 150, 25);
        add(userText);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 60, 80, 25);
        add(passLabel);

        passText = new JPasswordField();
        passText.setBounds(120, 60, 150, 25);
        add(passText);

        loginButton = new JButton("Login");
        loginButton.setBounds(120, 100, 80, 25);
        add(loginButton);

        loginButton.addActionListener(e -> login());
    }

    private void login() {
        String username = userText.getText();
        String password = new String(passText.getPassword());
        if ("Muneeswaran".equals(username) && "Munees@123".equals(password)) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Credentials");
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
