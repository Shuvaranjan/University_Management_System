import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Dasboard extends JFrame implements ActionListener {
    int mouseX, mouseY;

    private JLabel setimage1, setimage2, setimage4;
    private JPanel panel, panel2, panel3, makautpanel, makautpanel2, stdntPanel, facultyPanel, helpPanel;
    private JLabel stdntLabel, facultyLabel, helpLabel, makautlbl, makautlbl2, backgroundImg;
    private JDialog dialog;
    private JButton color1, color2, color3, color4;
    private JLabel minimizeButton, closeButton, maximizeButton;

    public Dasboard() {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(0, 0, 1650, 900);
        // setLocation(300,50);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 1));

        // getContentPane().setBackground(new Color(25, 193, 193));

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Images/Books.jpg"));
        Image img1 = img.getImage().getScaledInstance(1600, 880, Image.SCALE_SMOOTH);
        ImageIcon img3 = new ImageIcon(img1);
        backgroundImg = new JLabel(img3);
        backgroundImg.setBounds(50, 50, 1600, 880);
        add(backgroundImg);

        makautpanel2 = new JPanel();
        makautpanel2.setBounds(300, 250, 800, 200);
        makautpanel2.setOpaque(false);
        makautpanel2.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 120), 5));
        backgroundImg.add(makautpanel2);

        // ImageIcon img10 = new
        // ImageIcon(ClassLoader.getSystemResource("Images/M2.png"));
        // Image img20 = img10.getImage().getScaledInstance(700, 150,
        // Image.SCALE_SMOOTH);
        // ImageIcon img30 = new ImageIcon(img20);
        // backgroundImg2 = new JLabel(img30);
        // backgroundImg2.setBounds(50, 50, 800, 200);
        // makautpanel2.add(backgroundImg2);

        makautlbl2 = new JLabel("MAKAUT");
        makautlbl2.setForeground(new Color(255, 255, 255, 180));
        makautlbl2.setFont(new Font("Dialog", Font.BOLD, 150));
        makautpanel2.add(makautlbl2);

        // head Panel
        panel = new JPanel();
        panel.setBounds(0, 0, 1600, 50);
        panel.setBackground(new Color(96, 166, 0));
        panel.setLayout(null);
        // panel.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.WHITE));

        getContentPane().add(panel);

        // Menu Bar
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Images/menu-bar-50.png"));
        Image i1 = image1.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i1);
        setimage1 = new JLabel(i3);
        setimage1.setBounds(0, -15, 50, 80);
        setimage1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setimage1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                panel2.setVisible(true);
                setimage1.setVisible(false);
                setimage4.setVisible(true);
                backgroundImg.setBounds(410, 50, 1200, 880);
                makautpanel2.setBounds(180, 250, 700, 200);

            }

        });
        panel.add(setimage1);

        // Close button
        closeButton = new JLabel("x");
        closeButton.setBounds(1500, 0, 20, 40);
        closeButton.setBackground(new Color(255, 0, 0));
        closeButton.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        closeButton.setForeground(new Color(236, 0, 36));
        closeButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                closeButton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closeButton.setForeground(new Color(236, 0, 36));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // setVisible(false);
                int a = JOptionPane.showConfirmDialog(Dasboard.this, "Are you Exit it ?", "",
                        JOptionPane.YES_NO_OPTION);

                if (a == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else if (a == JOptionPane.NO_OPTION) {
                    return;
                }
            }

        });
        panel.add(closeButton);

        // Minimize button
        minimizeButton = new JLabel("_");
        minimizeButton.setBounds(1430, -8, 20, 40);
        minimizeButton.setBackground(new Color(255, 0, 0));
        minimizeButton.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        minimizeButton.setForeground(new Color(236, 0, 36));
        minimizeButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                minimizeButton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                minimizeButton.setForeground(new Color(236, 0, 36));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                setExtendedState(JFrame.ICONIFIED);
            }

        });
        panel.add(minimizeButton);

        maximizeButton = new JLabel("🗖");
        maximizeButton.setBounds(1460, 0, 30, 45);
        maximizeButton.setBackground(new Color(255, 0, 0));
        maximizeButton.setFont(new Font("", Font.BOLD, 15));
        maximizeButton.setForeground(new Color(236, 0, 36));
        maximizeButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                maximizeButton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                maximizeButton.setForeground(new Color(236, 0, 36));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                    JPanel panel = new JPanel();
                    panel.setBounds(0, 0, 1200, 30);
                    panel.setBackground(null);
                    panel.addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent e) {
                            setOpacity(0.7f);

                            mouseX = e.getX();
                            mouseY = e.getY();
                        }

                        public void mouseReleased(MouseEvent e) {
                            setOpacity(1f);

                        }
                    });

                    panel.addMouseMotionListener(new MouseAdapter() {
                        public void mouseDragged(MouseEvent e) {
                            int x = e.getXOnScreen() - mouseX;
                            int y = e.getYOnScreen() - mouseY;

                            setLocation(x, y);
                        };
                    });
                    add(panel);
                    setSize(1200, 700);
                    setLocation(200, 100);
                    minimizeButton.setBounds(1105, -8, 20, 40);
                    maximizeButton.setBounds(1130, 0, 30, 45);
                    closeButton.setBounds(1170, 0, 20, 40);
                    setimage2.setBounds(-2, 600, 50, 50);
                    makautpanel2.setBounds(300, 250, 700, 150);
                    makautpanel2.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 120), 5));

                    makautlbl2 = new JLabel("MAKAUT");
                    makautlbl2.setForeground(new Color(255, 255, 255, 180));
                    makautlbl2.setFont(new Font("Dialog", Font.BOLD, 150));

                    makautpanel2.add(makautlbl2);

                    setimage1.addMouseListener(new MouseAdapter() {

                        @Override
                        public void mouseClicked(MouseEvent e) {
                            panel2.setVisible(true);
                            setimage1.setVisible(false);
                            setimage4.setVisible(true);
                            backgroundImg.setBounds(410, 50, 1200, 880);
                            makautpanel2.setBounds(100, 250, 500, 150);

                        }

                    });

                    setimage4.addMouseListener(new MouseAdapter() {

                        @Override
                        public void mouseClicked(MouseEvent e) {
                            panel2.setVisible(false);
                            setimage4.setVisible(false);
                            setimage1.setVisible(true);
                            backgroundImg.setBounds(50, 50, 1600, 880);
                            makautpanel2.setBounds(300, 250, 700, 150);
                        }

                    });
                    minimizeButton.addMouseListener(new MouseAdapter() {

                        @Override
                        public void mouseEntered(MouseEvent e) {
                            minimizeButton.setForeground(Color.WHITE);
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            minimizeButton.setForeground(new Color(236, 0, 36));
                        }

                        @Override
                        public void mouseClicked(MouseEvent e) {

                            if (getExtendedState() == JFrame.ICONIFIED) {
                                setSize(1200, 700);
                                setLocation(200, 100);
                            }
                        }

                    });

                } else {
                    setExtendedState(JFrame.MAXIMIZED_BOTH);
                    closeButton.setBounds(1500, 0, 20, 40);
                    minimizeButton.setBounds(1430, -8, 20, 40);
                    maximizeButton.setBounds(1460, 0, 30, 45);
                    setimage2.setBounds(-2, 756, 50, 50);
                    makautpanel2.setBounds(300, 250, 800, 200);

                    minimizeButton.addMouseListener(new MouseAdapter() {

                        @Override
                        public void mouseEntered(MouseEvent e) {
                            minimizeButton.setForeground(Color.WHITE);
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            minimizeButton.setForeground(new Color(236, 0, 36));
                        }

                        @Override
                        public void mouseClicked(MouseEvent e) {

                            if (getExtendedState() == JFrame.ICONIFIED) {
                                setBounds(0, 0, 1650, 900);
                            }
                        }

                    });

                    makautlbl2 = new JLabel("MAKAUT");
                    makautlbl2.setForeground(new Color(255, 255, 255, 180));
                    makautlbl2.setFont(new Font("Dialog", Font.BOLD, 150));

                    makautpanel2.add(makautlbl2);

                    setimage1.addMouseListener(new MouseAdapter() {

                        @Override
                        public void mouseClicked(MouseEvent e) {
                            panel2.setVisible(true);
                            setimage1.setVisible(false);
                            setimage4.setVisible(true);
                            backgroundImg.setBounds(410, 50, 1200, 880);
                            makautpanel2.setBounds(180, 250, 700, 200);

                        }

                    });

                    setimage4.addMouseListener(new MouseAdapter() {

                        @Override
                        public void mouseClicked(MouseEvent e) {
                            panel2.setVisible(false);
                            setimage4.setVisible(false);
                            setimage1.setVisible(true);
                            backgroundImg.setBounds(50, 50, 1600, 880);
                            makautpanel2.setBounds(300, 250, 800, 200);
                        }

                    });

                }

            }

        });
        panel.add(maximizeButton);

        // Panel
        panel2 = new JPanel();
        panel2.setBounds(50, 50, 360, 850);
        panel2.setVisible(false);
        panel2.setBackground(new Color(36, 36, 36));
        panel2.setLayout(null);
        add(panel2);

        panel3 = new JPanel();
        panel3.setBounds(0, 50, 50, 820);
        panel3.setLayout(null);
        panel3.setBackground(new Color(79, 137, 0));
        add(panel3);
        // Exit
        ImageIcon image4 = new ImageIcon(ClassLoader.getSystemResource("Images/logout-50.png"));
        Image i7 = image4.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon i8 = new ImageIcon(i7);
        setimage4 = new JLabel(i8);
        setimage4.setBounds(0, -15, 50, 80);
        setimage4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setimage4.setVisible(false);
        // setimage4.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.RED));
        setimage4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                panel2.setVisible(false);
                setimage4.setVisible(false);
                setimage1.setVisible(true);
                backgroundImg.setBounds(50, 50, 1600, 880);
                makautpanel2.setBounds(300, 250, 800, 200);
            }

        });
        panel.add(setimage4);

        // Makaut
        makautlbl = new JLabel("Makaut");
        makautlbl.setBounds(100, 70, 150, 50);
        makautlbl.setForeground(new Color(255, 255, 255, 100));
        makautlbl.setFont(new Font("Tahoma", Font.BOLD, 40));
        panel2.add(makautlbl);

        makautpanel = new JPanel();
        makautpanel.setBounds(30, 70, 300, 50);
        makautpanel.setOpaque(false);
        makautpanel.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 25), 1));
        makautpanel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                makautlbl.setForeground(new Color(255, 255, 255));
                makautpanel.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 50), 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                makautpanel.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 25), 1));
                makautlbl.setForeground(new Color(255, 255, 255, 100));
            }

        });
        panel2.add(makautpanel);

        stdntPanel = new JPanel();
        stdntPanel.setBounds(0, 300, 370, 50);
        stdntPanel.setBackground(new Color(36, 36, 36));
        stdntPanel.setLayout(null);
        stdntPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        stdntPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(255, 255, 255, 10)));
        stdntPanel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                stdntPanel.setBackground(new Color(255, 255, 255));
                stdntLabel.setForeground(new Color(0, 0, 0));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                stdntLabel.setForeground(new Color(255, 255, 255));
                stdntPanel.setBackground(new Color(36, 36, 36));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                new Login().setVisible(true);
            }

        });
        panel2.add(stdntPanel);

        facultyPanel = new JPanel();
        facultyPanel.setBounds(0, 350, 370, 50);
        facultyPanel.setBackground(new Color(36, 36, 36));
        facultyPanel.setLayout(null);
        facultyPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        facultyPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(255, 255, 255, 10)));
        facultyPanel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new Faculty_Login().setVisible(true);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                facultyLabel.setForeground(new Color(0, 0, 0));
                facultyPanel.setBackground(new Color(255, 255, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                facultyPanel.setBackground(new Color(36, 36, 36));
                facultyLabel.setForeground(new Color(255, 255, 255));
            }

        });
        panel2.add(facultyPanel);

        helpPanel = new JPanel();
        helpPanel.setBounds(0, 550, 370, 50);
        helpPanel.setBackground(new Color(255, 0, 36));
        helpPanel.setLayout(null);
        helpPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(255, 255, 255, 10)));
        helpPanel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                helpLabel.setForeground(new Color(36, 36, 36));
                helpPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(255, 0, 36)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                helpLabel.setForeground(new Color(255, 255, 255));
                helpPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(255, 255, 255, 10)));
            }

            @Override
            public void mouseClicked(MouseEvent e) {

                new HelpDesk().setVisible(true);
            }

        });
        panel2.add(helpPanel);

        stdntLabel = new JLabel("Student Login(Click here)");
        stdntLabel.setBounds(75, 0, 350, 50);
        stdntLabel.setForeground(new Color(255, 255, 255));
        stdntLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        stdntPanel.add(stdntLabel);

        facultyLabel = new JLabel("Faculty Login(Click here)");
        facultyLabel.setBounds(75, 0, 350, 50);
        facultyLabel.setForeground(new Color(255, 255, 255));
        facultyLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        facultyPanel.add(facultyLabel);

        helpLabel = new JLabel("H   E   L   P");
        helpLabel.setBounds(100, 0, 350, 50);
        helpLabel.setForeground(new Color(255, 255, 255));
        helpLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        helpPanel.add(helpLabel);

        ImageIcon gearImg1 = new ImageIcon(ClassLoader.getSystemResource("Images/setting.png"));
        Image i2 = gearImg1.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon i4 = new ImageIcon(i2);
        setimage2 = new JLabel(i4);
        setimage2.setBounds(-2, 756, 50, 50);
        setimage2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setimage2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ColorChooser(panel, panel3).setVisible(true);
            }
        });
        panel3.add(setimage2);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Dasboard().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
