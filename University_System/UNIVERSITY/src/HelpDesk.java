import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.mail.Transport;
import java.awt.*;


public class HelpDesk extends JDialog  {
    private JLabel Name, Email1, Message1, Message2, Message3, Message4;
    private JTextField namTextField, toemailTextField;
    private JTextArea messagTextArea;
    private JButton sendButton;
    private JScrollPane scrollPane;
  
    
    public HelpDesk() {
        setTitle("Help Desk");
        setSize(700,500);
        setLocation(550,180);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        getContentPane().setBackground(new Color(34, 34, 34));
        setLayout(null);
        setResizable(false);





        addComponents();
    }
    
   private void addComponents() {
    
    ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("Images/M.png"));
    this.setIconImage(icon.getImage());



        Name = new JLabel("Name:");
        Name.setBounds(50, 50, 100, 30);
        Name.setForeground(Color.WHITE);
        Name.setFont(new Font("Calibri", Font.PLAIN, 20));
        add(Name);

        Email1 = new JLabel("Email:");
        Email1.setBounds(50, 120, 100, 30);
        Email1.setForeground(Color.WHITE);
        Email1.setFont(new Font("Calibri", Font.PLAIN, 20));
        add(Email1);
     

        Message1 = new JLabel("Message:");
        Message1.setBounds(50, 210, 100, 30);
        Message1.setForeground(Color.WHITE);
        Message1.setFont(new Font("Calibri", Font.PLAIN, 20));
        add(Message1);

    

        namTextField = new JTextField();
        namTextField.setBounds(150, 50, 400, 30);
        namTextField.setForeground(Color.DARK_GRAY);
        namTextField.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        add(namTextField);

        Message2 = new JLabel();
        Message2.setBounds(150, 80, 400, 30);
        Message2.setForeground(Color.RED);
        Message2.setFont(new Font("Calibri", Font.BOLD, 15));
        add(Message2);

     


        toemailTextField = new JTextField();
        toemailTextField.setBounds(150, 120, 400, 30);
        toemailTextField.setForeground(Color.DARK_GRAY);
        toemailTextField.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        add(toemailTextField);

        Message3 = new JLabel();
        Message3.setBounds(150, 150, 400, 30);
        Message3.setForeground(Color.RED);
        Message3.setFont(new Font("Calibri", Font.BOLD, 15));
        add(Message3);

    

        messagTextArea = new JTextArea();
        messagTextArea.setBounds(150, 250, 400, 150);
        messagTextArea.setBorder(BorderFactory.createEmptyBorder(3,2,2,2));
        messagTextArea.setForeground(Color.DARK_GRAY);
        
        Message4 = new JLabel();
        Message4.setBounds(150, 360, 400, 30);
        Message4.setForeground(Color.RED);
        Message4.setFont(new Font("Calibri", Font.BOLD, 15));
        add(Message4);
        // add(messagTextArea);
        scrollPane = new JScrollPane(messagTextArea);
        scrollPane.setBounds(150, 210, 400, 150);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane);
       


    

        sendButton = new JButton("Send");
        sendButton.setBounds(150, 420, 100, 30);
        sendButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sendButton.setBackground(new Color(0, 45, 191));
        sendButton.setForeground(Color.WHITE);
        sendButton.setFocusable(false);
        sendButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        sendButton.setBorder(BorderFactory.createLineBorder(new Color(255,255,255,150)));
       
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = namTextField.getText();
                String toemail = toemailTextField.getText();
                String fromemail = "shuvaranjan000@gmail.com";
                String fromemailPass = "plad tloq wacg eurf";
                String textArea = messagTextArea.getText();
                

                Properties properties = new Properties();
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");

                Session session = Session.getDefaultInstance(properties, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromemail,fromemailPass);
                    }
                });

                try {
                  
                    if (name.equals("") && toemail.equals("") && textArea.equals("")) {
                        Message2.setText("*required name");
                        Message3.setText("*required your email");
                        Message4.setText("*required message");
                        namTextField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                        namTextField.addKeyListener(new KeyAdapter() {

                            @Override
                            public void keyPressed(KeyEvent e) {
                                Message2.setText("");
                                namTextField.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
                            }
                           
                            
                          
                        });
                        toemailTextField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                        toemailTextField.addKeyListener(new KeyAdapter() {
                            
                            @Override
                            public void keyPressed(KeyEvent e){
                                Message3.setText("");
                                toemailTextField.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
                            }
                        });

                        messagTextArea.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                        messagTextArea.addKeyListener(new KeyAdapter() {

                            @Override
                            public void keyPressed(KeyEvent e) {
                                Message4.setText("");
                                messagTextArea.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
                            }
                            
                        });

                     
                        
                       
                        
                        
                    }else if (name.equals("") && !toemail.equals("") && !textArea.equals("")) {
                        Message2.setText("*required name");
                        namTextField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                        namTextField.addKeyListener(new KeyAdapter() {

                            @Override
                            public void keyPressed(KeyEvent e) {
                                Message2.setText("");
                                namTextField.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
                            }
                           
                            
                          
                        });
                    }

                    else if (name.equals("") && toemail.equals("") && !textArea.equals("")) {
                        Message2.setText("*required name");
                        Message3.setText("*required your email");
                        namTextField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                        namTextField.addKeyListener(new KeyAdapter() {

                            @Override
                            public void keyPressed(KeyEvent e) {
                                Message2.setText("");
                                namTextField.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
                            }
                           
                            
                          
                        });
                        toemailTextField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                        toemailTextField.addKeyListener(new KeyAdapter() {
                            
                            @Override
                            public void keyPressed(KeyEvent e){
                                Message3.setText("");
                                toemailTextField.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
                            }
                        });
                    }
                    else if (!name.equals("") && toemail.equals("") && textArea.equals("")) {
                        Message3.setText("*required your email");
                        Message4.setText("*required message");
                        toemailTextField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                        toemailTextField.addKeyListener(new KeyAdapter() {
                            
                            @Override
                            public void keyPressed(KeyEvent e){
                                Message3.setText("");
                                toemailTextField.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
                            }
                        });

                        messagTextArea.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                        messagTextArea.addKeyListener(new KeyAdapter() {

                            @Override
                            public void keyPressed(KeyEvent e) {
                                Message4.setText("");
                                messagTextArea.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
                            }
                            
                        });
                    }
                    else if (!name.equals("") && !toemail.equals("") && textArea.equals("")) {
                        Message4.setText("*required message");
                        messagTextArea.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                        messagTextArea.addKeyListener(new KeyAdapter() {

                            @Override
                            public void keyPressed(KeyEvent e) {
                                Message4.setText("");
                                messagTextArea.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
                            }
                            
                        });
                    }
                    else if (!name.equals("") && toemail.equals("") && !textArea.equals("")) {
                        Message3.setText("*required your email");
                        toemailTextField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                        toemailTextField.addKeyListener(new KeyAdapter() {
                            
                            @Override
                            public void keyPressed(KeyEvent e){
                                Message3.setText("");
                                toemailTextField.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
                            }
                        });
                    }
                    
                    
                    else if (!name.equals("") && !toemail.equals("") && !textArea.equals("")) {
                        MimeMessage mimeMessage = new MimeMessage(session);
                        mimeMessage.setFrom(new InternetAddress(toemail));
                        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(fromemail));
                        mimeMessage.setSubject(name);
                        mimeMessage.setText(messagTextArea.getText());
                        Transport.send(mimeMessage);
                        JOptionPane.showMessageDialog(HelpDesk.this, "Message send successfully");
                        HelpDesk.this.dispose();
                    }
                   
                   
                } catch (Exception ef) {
                JOptionPane.showMessageDialog(null, "Please Connect the Internet and Try again!");
                }
            }
        });

     
        add(sendButton);

       

        
        
    }

public static void main(String[] args) {
   SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        new HelpDesk().setVisible(true);
    }
  
   });
   }
    
    
}
