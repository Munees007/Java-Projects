package UI;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Thirukkural_App extends JFrame {
    Color bgColor = new Color(52,90,64);
    public Thirukkural_App() throws IOException
    {
        super();
        setTitle("\u0BA4\u0BBF\u0BB0\u0BC1\u0B95\u0BCD\u0B95\u0BC1\u0BB1\u0BB3\u0BCD \u0B9A\u0BC6\u0CAF\u0BB2\u0BBF");
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        BufferedImage logo = ImageIO.read(new File("Resources/Images/thiruvalluvar.png"));
        setIconImage(logo);

        setLayout(new BorderLayout());
        Image scaledlogo = logo.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        JLabel front = new JLabel(new ImageIcon(scaledlogo));
        add(front,BorderLayout.NORTH);
        Thirukkural thiru = new Thirukkural();
        thiru.setPreferredSize(new Dimension(550, 340)); // fixed width & height

        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        wrapper.setBackground(bgColor);
        wrapper.add(thiru);

        add(wrapper, BorderLayout.CENTER);

        getContentPane().setBackground(bgColor);
        setResizable(false);
        setVisible(true);
    }
}
