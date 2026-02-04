package ui;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;



public class PopMenu  extends JFrame implements MouseListener, ActionListener{

    JPopupMenu popupMenu;
    JLabel image = new JLabel("");
    public PopMenu()
    {
        setTitle("Popup Menu");
        setSize(500,300);
        setLayout(new BorderLayout());
        createMenuBar();
        
        add(popupMenu);
        image.setHorizontalAlignment(JLabel.CENTER);
        image.setVerticalAlignment(JLabel.CENTER);
        add(image,BorderLayout.CENTER);
        addMouseListener(this);
        setVisible(true);
    }
    void createMenuBar()
    {
        popupMenu = new JPopupMenu();
        JMenu series = new JMenu("Series");
        JMenu animes = new JMenu("Animes");

        JMenuItem supernatural = new JMenuItem("Supernatural");
        JMenuItem originals = new JMenuItem("The Originals");
        supernatural.addActionListener(this);
        originals.addActionListener(this);
        series.add(supernatural);
        series.add(originals);
        JMenuItem slayer = new JMenuItem("Demon Slayer");
        JMenuItem clover = new JMenuItem("Black Clover");
        JMenuItem jjk = new JMenuItem("Jujutsu kaisen");
        slayer.addActionListener(this);
        clover.addActionListener(this);
        jjk.addActionListener(this);
        animes.add(slayer);
        animes.add(clover);
        animes.add(jjk);
        popupMenu.add(series);
        popupMenu.add(animes);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.isPopupTrigger())
        {
            popupMenu.show(this, e.getX(),e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.isPopupTrigger())
        {
            popupMenu.show(this, e.getX(),e.getY());
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
        JMenuItem mi = (JMenuItem) e.getSource();
        String label = mi.getLabel();
        int width = 450, height = 250;
        if(label.equals("Supernatural"))
        {
            
            image.setIcon(GenerateImage.create("/spn.jpg", width, height));
        }
        else if(label.equals("The Originals"))
        {
            image.setIcon(GenerateImage.create("/originals.jpg", width, height));
        }
        else if(label.equals("Demon Slayer"))
        {
            image.setIcon(GenerateImage.create("/slayer.jpg", width, height));
        }
        else if(label.equals("Black Clover"))
        {
            image.setIcon(GenerateImage.create("/asta.jpg", width, height));
        }
        else if(label.equals("Jujutsu kaisen"))
        {
            image.setIcon(GenerateImage.create("/jjk.jpg", width, height));
        }
    }

}
