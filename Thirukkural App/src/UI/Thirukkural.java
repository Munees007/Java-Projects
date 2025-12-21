package UI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Thirukkural extends JPanel {
    Color borderColor = new Color(163,177,138);
    public  Thirukkural()
    {
        super();
        setBackground(Color.white);
        setBorder(new LineBorder(borderColor,5));
        setLayout(new BorderLayout());
        JTextField input = new JTextField();
        setBorder(new EmptyBorder(10,10,10,10));
        add(input,BorderLayout.NORTH);

        JButton fetch = new JButton("Fetch");
        fetch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(input.getText());
            }
        });
        add(fetch,BorderLayout.SOUTH);

    }
}
