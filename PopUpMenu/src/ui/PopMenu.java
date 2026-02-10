package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopMenu extends JFrame implements MouseListener, ActionListener {

    JPopupMenu popupMenu;
    JLabel label = new JLabel("Right-click to change color");

    public PopMenu() {
        setTitle("Color Popup Menu");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createMenuBar();

        add(label);
        addMouseListener(this);
        setVisible(true);
    }

    void createMenuBar() {
        popupMenu = new JPopupMenu();

        JMenuItem redItem = new JMenuItem("Red");
        JMenuItem greenItem = new JMenuItem("Green");
        JMenuItem blueItem = new JMenuItem("Blue");
        JMenuItem cyanItem = new JMenuItem("Cyan");
        JMenuItem yellowItem = new JMenuItem("Yellow");

        redItem.addActionListener(this);
        greenItem.addActionListener(this);
        blueItem.addActionListener(this);
        cyanItem.addActionListener(this);
        yellowItem.addActionListener(this);

        popupMenu.add(redItem);
        popupMenu.add(greenItem);
        popupMenu.add(blueItem);
        popupMenu.add(cyanItem);
        popupMenu.add(yellowItem);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger()) {
            popupMenu.show(this, e.getX(), e.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) {
            popupMenu.show(this, e.getX(), e.getY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String colorName = e.getActionCommand();
        switch (colorName) {
            case "Red":
                getContentPane().setBackground(Color.RED);
                break;
            case "Green":
                getContentPane().setBackground(Color.GREEN);
                break;
            case "Blue":
                getContentPane().setBackground(Color.BLUE);
                break;
            case "Cyan":
                getContentPane().setBackground(Color.CYAN);
                break;
            case "Yellow":
                getContentPane().setBackground(Color.YELLOW);
                break;
        }
    }
}
