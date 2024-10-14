import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import Database.Conn;

public class Faculty_Login extends JDialog implements ActionListener {
    private JLabel lblUsername, lblPassword, showWarning, showWarning2;
    private JTextField tfUsername;
    private JPasswordField tfPassword;
    private JButton loginButton;
    private JButton cancelButton;

    public Faculty_Login() {
        setSize(600, 300);
        setModal(true);
        setLocation(500, 250);
        getContentPane().setBackground(new Color(0, 94, 191));
        // setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        setTitle("Faculty Login");
        setResizable(false);

        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/login.png"));
        Image i2 = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon i4 = new ImageIcon(i2);
        this.setIconImage(i4.getImage());

        lblUsername = new JLabel("Username");
        lblUsername.setBounds(50, 20, 100, 50);
        lblUsername.setFont(new Font("Calbri", Font.BOLD, 16));
        lblUsername.setForeground(Color.WHITE);
        add(lblUsername);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(50, 80, 100, 50);
        lblPassword.setFont(new Font("Calbri", Font.BOLD, 16));
        lblPassword.setForeground(Color.WHITE);
        add(lblPassword);

        tfUsername = new JTextField();
        tfUsername.setBounds(150, 40, 170, 20);
        tfUsername.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(tfUsername);

        showWarning = new JLabel("");
        showWarning.setBounds(150, 60, 170, 20);
        showWarning.setFont(new Font("Calbri", Font.BOLD, 12));
        showWarning.setForeground(Color.RED);
        add(showWarning);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(150, 100, 170, 20);
        tfPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(tfPassword);

        showWarning2 = new JLabel("");
        showWarning2.setBounds(150, 120, 170, 20);
        showWarning2.setFont(new Font("Calbri", Font.BOLD, 12));
        showWarning2.setForeground(Color.RED);
        add(showWarning2);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 180, 120, 30);
        loginButton.setBackground(new Color(20, 20, 20));
        loginButton.setForeground(new Color(255, 255, 255, 150));
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        loginButton.addActionListener(this);
        loginButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setForeground(Color.WHITE);
                loginButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setForeground(new Color(255, 255, 255, 150));
                loginButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            }
        });

        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(198, 180, 120, 30);
        cancelButton.setBackground(new Color(20, 20, 20));
        cancelButton.setForeground(new Color(255, 255, 255, 150));
        cancelButton.setFont(new Font("Arial", Font.BOLD, 18));
        cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cancelButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        cancelButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                cancelButton.setForeground(Color.WHITE);
                cancelButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelButton.setForeground(new Color(255, 255, 255, 150));
                cancelButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            }

        });
        cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Faculty_Login.this.dispose();

            }

        });
        add(cancelButton);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Images/user-100.png"));
        Image i1 = image1.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i1);
        JLabel setimage1 = new JLabel(i3);
        setimage1.setBounds(370, 30, 200, 200);
        add(setimage1);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Faculty_Login().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {
            String username = tfUsername.getText();
            String password = String.valueOf(tfPassword.getPassword());

            String query = "select * from faculty_login where username = '" + username + "'and password = '" + password
                    + "'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (username.equals("") && password.equals("")) {

                    tfUsername.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    tfPassword.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    JOptionPane.showMessageDialog(Faculty_Login.this, "Enter Username and Password");
                    tfUsername.setBorder(BorderFactory.createEmptyBorder());
                    tfPassword.setBorder(BorderFactory.createEmptyBorder());
                }

                else if (username.equals("") && !password.equals("")) {
                    showWarning.setText("*Enter Username");
                    tfUsername.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    tfUsername.addKeyListener(new KeyAdapter() {

                        @Override
                        public void keyPressed(KeyEvent e) {
                            showWarning.setText("");
                            tfUsername.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                        }

                    });

                } else if (!username.equals("") && password.equals("")) {
                    showWarning2.setText("*Enter Password");
                    tfPassword.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    tfPassword.addKeyListener(new KeyAdapter() {

                        @Override
                        public void keyPressed(KeyEvent e) {
                            showWarning2.setText("");
                            tfPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                        }

                    });

                } else if (rs.next()) {
                    Faculty_Login.this.dispose();
                    new Project2().setVisible(true);
                    JOptionPane.showMessageDialog(Faculty_Login.this, "Login Succesfull");

                } else {
                    tfUsername.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    tfPassword.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    JOptionPane.showMessageDialog(Faculty_Login.this, "Login Failed");
                    tfUsername.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                    tfPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                    tfUsername.setText(null);
                    tfPassword.setText(null);

                }
                c.s.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
