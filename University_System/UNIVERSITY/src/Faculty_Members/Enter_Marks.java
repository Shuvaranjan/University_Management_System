package Faculty_Members;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Database.Conn;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class Enter_Marks extends JDialog implements ActionListener {
    private JLabel heading_label, lblroll, lblsemester, enterSubject, enterMarks;
    private JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5, tfmarks1, tfmarks2, tfmarks3, tfmarks4, tfmarks5;
    private JPanel headPanel;
    private Choice crollno;
    private JComboBox cbsemester;
    private JButton submitButton, cancelButton;

    public Enter_Marks() {
        setTitle("Marks");
        setSize(1000, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setModal(true);
        setLocation(300, 150);
        getContentPane().setBackground(new Color(0, 0, 0, 250));

        addComponents();
    }

    private void addComponents() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/makaut2.png"));
        Image i2 = i1.getImage().getScaledInstance(420, 300, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel backgroundImage = new JLabel(i3);
        backgroundImage.setBounds(540, 110, 420, 300);
        backgroundImage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        add(backgroundImage);

        // heading panel
        headPanel = new JPanel();
        headPanel.setBackground(new Color(255, 255, 255, 150));
        headPanel.setBounds(0, 20, 1000, 50);
        headPanel.setLayout(null);
        add(headPanel);
        // heading
        heading_label = new JLabel("Enter  Marks  of  Student");
        heading_label.setBounds(320, 0, 500, 50);
        heading_label.setForeground(new Color(0, 0, 0, 250));
        heading_label.setFont(new Font("Bodoni MT Black", Font.BOLD, 32));
        headPanel.add(heading_label);

        // Border
        JLabel b = new JLabel();
        b.setBounds(20, 90, 480, 400);
        b.setBorder(BorderFactory.createLineBorder(new Color(9, 0, 255, 85), 3));
        b.setLayout(null);
        add(b);

        // roll number
        lblroll = new JLabel("Select Roll number:");
        lblroll.setBounds(15, 15, 150, 20);
        lblroll.setForeground(Color.WHITE);
        lblroll.setFont(new Font("Calibri", Font.BOLD, 18));
        b.add(lblroll);

        // roll no chooser
        crollno = new Choice();
        crollno.setBounds(180, 12, 150, 20);
        crollno.setFont(new Font("", Font.PLAIN, 12));
        b.add(crollno);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * From student");
            while (rs.next()) {
                crollno.add(rs.getString("roll"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // semester
        lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(15, 55, 150, 20);
        lblsemester.setForeground(Color.WHITE);
        lblsemester.setFont(new Font("Calibri", Font.BOLD, 18));
        b.add(lblsemester);

        String semester[] = { "1st semester", "2nd semester", "3rd semester", "4th semester", "5th semester",
                "6th semester", "7th semester", "8th semester" };
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(180, 55, 150, 20);
        cbsemester.setFont(new Font("", Font.PLAIN, 12));
        b.add(cbsemester);

        // subject
        enterSubject = new JLabel("Enter Subject");
        enterSubject.setBounds(70, 100, 200, 40);
        enterSubject.setForeground(Color.WHITE);
        enterSubject.setFont(new Font("Tahoma", Font.PLAIN, 15));
        b.add(enterSubject);

        // marks
        enterMarks = new JLabel("Enter Marks");
        enterMarks.setBounds(300, 100, 200, 40);
        enterMarks.setForeground(Color.WHITE);
        enterMarks.setFont(new Font("Tahoma", Font.PLAIN, 15));
        b.add(enterMarks);

        tfsub1 = new JTextField();
        tfsub1.setBounds(20, 150, 200, 20);
        tfsub1.setBorder(BorderFactory.createEmptyBorder());
        tfsub1.setHorizontalAlignment(SwingConstants.CENTER);
        tfsub1.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
                    tfsub1.setEditable(true);

                } else {
                    tfsub1.setEditable(false);
                }
            }

        });
        b.add(tfsub1);

        tfsub2 = new JTextField();
        tfsub2.setBounds(20, 180, 200, 20);
        tfsub2.setBorder(BorderFactory.createEmptyBorder());
        tfsub2.setHorizontalAlignment(SwingConstants.CENTER);
        tfsub2.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
                    tfsub2.setEditable(true);

                } else {
                    tfsub2.setEditable(false);
                }
            }

        });
        b.add(tfsub2);

        tfsub3 = new JTextField();
        tfsub3.setBounds(20, 210, 200, 20);
        tfsub3.setBorder(BorderFactory.createEmptyBorder());
        tfsub3.setHorizontalAlignment(SwingConstants.CENTER);
        tfsub3.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
                    tfsub3.setEditable(true);

                } else {
                    tfsub3.setEditable(false);
                }
            }

        });
        b.add(tfsub3);

        tfsub4 = new JTextField();
        tfsub4.setBounds(20, 240, 200, 20);
        tfsub4.setBorder(BorderFactory.createEmptyBorder());
        tfsub4.setHorizontalAlignment(SwingConstants.CENTER);
        tfsub4.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
                    tfsub4.setEditable(true);

                } else {
                    tfsub4.setEditable(false);
                }
            }

        });
        b.add(tfsub4);

        tfsub5 = new JTextField();
        tfsub5.setBounds(20, 270, 200, 20);
        tfsub5.setBorder(BorderFactory.createEmptyBorder());
        tfsub5.setHorizontalAlignment(SwingConstants.CENTER);
        tfsub5.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
                    tfsub5.setEditable(true);

                } else {
                    tfsub5.setEditable(false);
                }
            }

        });
        b.add(tfsub5);

        tfmarks1 = new JTextField();
        tfmarks1.setBounds(240, 150, 200, 20);
        tfmarks1.setBorder(BorderFactory.createEmptyBorder());
        tfmarks1.setHorizontalAlignment(SwingConstants.CENTER);
        b.add(tfmarks1);

        tfmarks2 = new JTextField();
        tfmarks2.setBounds(240, 180, 200, 20);
        tfmarks2.setBorder(BorderFactory.createEmptyBorder());
        tfmarks2.setHorizontalAlignment(SwingConstants.CENTER);
        b.add(tfmarks2);

        tfmarks3 = new JTextField();
        tfmarks3.setBounds(240, 210, 200, 20);
        tfmarks3.setBorder(BorderFactory.createEmptyBorder());
        tfmarks3.setHorizontalAlignment(SwingConstants.CENTER);
        b.add(tfmarks3);

        tfmarks4 = new JTextField();
        tfmarks4.setBounds(240, 240, 200, 20);
        tfmarks4.setBorder(BorderFactory.createEmptyBorder());
        tfmarks4.setHorizontalAlignment(SwingConstants.CENTER);
        b.add(tfmarks4);

        tfmarks5 = new JTextField();
        tfmarks5.setBounds(240, 270, 200, 20);
        tfmarks5.setBorder(BorderFactory.createEmptyBorder());
        tfmarks5.setHorizontalAlignment(SwingConstants.CENTER);
        b.add(tfmarks5);

        submitButton = new JButton("Submit");
        submitButton.setBounds(100, 350, 120, 30);
        submitButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        submitButton.setForeground(new Color(255, 255, 255, 100));
        submitButton.setBackground(new Color(67, 181, 0));
        submitButton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitButton.addActionListener(this);
        submitButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                submitButton.setForeground(new Color(255, 255, 255));
                submitButton.setBackground(new Color(20, 255, 0));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                submitButton.setForeground(new Color(255, 255, 255, 100));
                submitButton.setBackground(new Color(67, 181, 0));
            }

        });
        b.add(submitButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(250, 350, 120, 30);
        cancelButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancelButton.setBackground(new Color(170, 0, 0));
        cancelButton.setForeground(new Color(255, 255, 255, 100));
        cancelButton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cancelButton.addActionListener(this);
        cancelButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                cancelButton.setBackground(new Color(221, 0, 0));
                cancelButton.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelButton.setBackground(new Color(170, 0, 0));
                cancelButton.setForeground(new Color(255, 255, 255, 100));
            }

        });
        b.add(cancelButton);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Enter_Marks().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {
            String subj1 = tfsub1.getText();
            String subj2 = tfsub1.getText();
            String subj3 = tfsub1.getText();
            String subj4 = tfsub1.getText();
            String subj5 = tfsub1.getText();

            try {

                if (subj1.equals("") && subj2.equals("") && subj3.equals("") && subj4.equals("") && subj5.equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "<html><body style=\'color:rgb(255,0,36);\'>Please Enter the Subject</body></html>");

                } else {

                    Conn conn = new Conn();
                    String query1 = "INSERT INTO subject VALUES('" + crollno.getSelectedItem() + "','"
                            + cbsemester.getSelectedItem() + "', '" + tfsub1.getText() + "', '" + tfsub2.getText()
                            + "', '" + tfsub3.getText() + "', '" + tfsub4.getText() + "', '" + tfsub5.getText() + "' )";

                    String query2 = "INSERT INTO marks VALUES('" + crollno.getSelectedItem() + "','"
                            + cbsemester.getSelectedItem() + "', '" + tfmarks1.getText() + "', '" + tfmarks2.getText()
                            + "', '" + tfmarks3.getText() + "', '" + tfmarks4.getText() + "', '" + tfmarks5.getText()
                            + "' )";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,
                            "<html><body style=\'color:green;\'>Marks Inserted Successfully...</body></html>");
                    this.dispose();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "RollNo Already Exists");
            }
        } else {
            this.dispose();
        }
    }
}
