import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class ColorChooser extends JDialog {
    private JButton color1, color2, color3, color4;
    public JPanel panel, panel3;

    ColorChooser(JPanel panel, JPanel panel3) {
        this.panel = panel;
        this.panel3 = panel3;
        setSize(500, 200);
        setLocation(600, 250);
        setModal(true);
        setLayout(new FlowLayout(1, 25, 50));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(44, 44, 44));
        
        addComponents();

    }

    private void addComponents() {
        color1 = new JButton("Color1");
        color1.setForeground(Color.WHITE);
        color1.setFocusable(false);
        color1.setBackground(Color.BLACK);
        color1.setFont(new Font("Calibri", Font.BOLD, 20));
        color1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        color1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.DARK_GRAY);
                panel3.setBackground(new Color(255, 0, 36));
                setVisible(false);

            }

        });

        add(color1);

        color2 = new JButton("Color2");
        // color2.setBounds(10,50,100,50);
        color2.setForeground(Color.WHITE);
        color2.setBackground(Color.BLACK);
        color2.setFocusable(false);
        color2.setBounds(0, 50, 100, 50);
        color2.setFont(new Font("Calibri", Font.BOLD, 20));
        color2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        color2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(new Color(12, 0, 255));
                panel3.setBackground(new Color(9, 0, 186));
                setVisible(false);

            }

        });
        add(color2);

        color3 = new JButton("Color3");
        color3.setForeground(Color.WHITE);
        color3.setBackground(Color.BLACK);
        color3.setFocusable(false);
        color3.setFont(new Font("Calibri", Font.BOLD, 20));
        color3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        color3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(new Color(20, 20, 20));
                panel3.setBackground(new Color(12, 12, 12));
                setVisible(false);

            }

        });
        add(color3);

        color4 = new JButton("Color4");
        color4.setForeground(Color.WHITE);
        color4.setBackground(Color.BLACK);
        color4.setFocusable(false);
        color4.setFont(new Font("Calibri", Font.BOLD, 20));
        color4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        color4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(new Color(96, 166, 0));
                panel3.setBackground(new Color(79, 137, 0));
                setVisible(false);

            }

        });
        add(color4);

    }
}
