import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JLabel emojiLabel;

    public App() {
        setTitle("Emoji Display with Radio Buttons");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        emojiLabel = new JLabel("😊", JLabel.CENTER);
        emojiLabel.setFont(new Font("Serif", Font.PLAIN, 100));
        add(emojiLabel, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JRadioButton happy = new JRadioButton("Happy", true);
        JRadioButton sad = new JRadioButton("Sad");
        JRadioButton cool = new JRadioButton("Cool");
        JRadioButton wink = new JRadioButton("Wink");

        ButtonGroup group = new ButtonGroup();
        group.add(happy);
        group.add(sad);
        group.add(cool);
        group.add(wink);

        panel.add(happy);
        panel.add(sad);
        panel.add(cool);
        panel.add(wink);

        add(panel, BorderLayout.SOUTH);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                switch (cmd) {
                    case "Happy": emojiLabel.setText("😊"); break;
                    case "Sad":   emojiLabel.setText("😢"); break;
                    case "Cool":  emojiLabel.setText("😎"); break;
                    case "Wink":  emojiLabel.setText("😉"); break;
                }
            }
        };

        happy.addActionListener(listener);
        sad.addActionListener(listener);
        cool.addActionListener(listener);
        wink.addActionListener(listener);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App());
    }
}
