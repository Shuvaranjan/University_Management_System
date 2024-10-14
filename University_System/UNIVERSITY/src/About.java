import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class About extends JDialog {
    public About(){
        setTitle("About");
        setSize(750,530);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(95, 0, 255));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setModal(true);
        addComponents();
    }
    private void addComponents() {
      
        
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Images/ABS1.jpeg"));
        Image i1 = image1.getImage().getScaledInstance(750, 530, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i1);
        JLabel setimage1 = new JLabel(i3);
        setimage1.setBounds(0,0,750,530);
        setimage1.setLayout(null);
        setimage1.setBorder(BorderFactory.createEmptyBorder());
        add(setimage1);

        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("Images/myself.jpg"));
        Image i2 = image2.getImage().getScaledInstance(250, 140, Image.SCALE_SMOOTH);
        ImageIcon i4 = new ImageIcon(i2);
        JLabel setimage2 = new JLabel(i4);
        setimage2.setBounds(220,90,250,140);
        setimage2.setBorder(BorderFactory.createLineBorder(new Color(0, 55, 238,90),2));
        setimage1.add(setimage2);


        //Main Panel
        JPanel panel = new JPanel();
        panel.setBounds(40,20,650,450);
        panel.setLayout(null);
        panel.setBackground(new Color(0, 55, 238,150));
        panel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255,55),2));
        setimage1.add(panel);

        //Sub Panel
        JPanel panel2 = new JPanel();
        panel2.setBounds(0,20,650,40);
        panel2.setBackground(new Color(255, 251, 2));
        panel2.setBorder(BorderFactory.createLineBorder(new Color(255,255,255,55),2));
        panel2.setLayout(null);
        panel.add(panel2);
        
        JLabel heading = new JLabel("University Management System");
        heading.setBounds(60,-5,560,50);
        heading.setForeground(new Color(0, 55, 238,150));
        heading.setFont(new Font("Bodoni MT Black", Font.BOLD, 30));
        panel2.add(heading);
      
        JLabel name = new JLabel("Developed by: Shuvaranjan Sarkar(2024)");
        name.setBounds(20,230,500,30);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        panel.add(name);

        JLabel email = new JLabel("Email: shuvaranjans@gmail.com");
        email.setBounds(20,280,500,30);
        email.setForeground(Color.WHITE);
        email.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        panel.add(email);

        JLabel contact = new JLabel("Contact: 9064714325");
        contact.setBounds(20,330,500,30);
        contact.setForeground(Color.WHITE);
        contact.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        panel.add(contact);

        JLabel wp = new JLabel("WhatsApp: 7797159292");
        wp.setBounds(20,380,300,30);
        wp.setForeground(Color.WHITE);
        wp.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        panel.add(wp);

        JLabel know_more = new JLabel("<html><body><u>Know more about</u></body></html>");
        know_more.setBounds(350,380,200,30);
        know_more.setForeground(Color.WHITE);
        know_more.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        know_more.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        know_more.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
              Desktop browser = Desktop.getDesktop();
              try {
                browser.browse(new URI("https://shuvaranjan.github.io/Portfolio/"));
              } catch (Exception exp) {
               JOptionPane.showMessageDialog(null, "Please connect the Internet and Try again!");
              }
            }

         

            
            
        });
        panel.add(know_more);

        

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
              new About().setVisible(true);
            }
            
        });
    }
}
