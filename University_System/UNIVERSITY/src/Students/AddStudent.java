package Students;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import com.toedter.calendar.JDateChooser;

import Database.Conn;

public class AddStudent extends JDialog implements ActionListener{
    //Panel
    private JPanel headPanel;
    //Label
    private JLabel heading_label, name_label, roll_label, address_label, email_label, hs_percentagelabel, course_label, father_namelabel, dob_label, ph_label,  board_percentagelabel,aadhar_nolabel, branch_label, name2, roll2, email2, board2, course2, father_name2, dob2, ph2, aAdhar2, hs2, branch2;
    //Textfield
    private JTextField namField, addressField, emailField, father_nameField,board_percentageField, phField, aAdharField, hs_percentageField;
    //Button
    private JButton submit, cancel, clear;
    //DateChooser
    private JDateChooser dateChooserdob;
    //ComboBox
    private JComboBox cbCourse, cbBranch;
    

    Random random = new Random();
    long first3 = Math.abs((random.nextLong() % 900L) + 100L)+1;

    public AddStudent() {
        setTitle("Student Details");
        setSize(950, 700);
        setLocation(320, 100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(0, 42, 226));
        setModal(true);
        setLayout(null);

        addComponents();

    }

    private void addComponents() {

        // heading
        headPanel = new JPanel();
        headPanel.setBackground(new Color(255, 255, 255, 150));
        headPanel.setBounds(0, 20, 950, 50);
        headPanel.setLayout(null);
        add(headPanel);

        // heading
        heading_label = new JLabel("New Student Details");
        heading_label.setBounds(320, 0, 500, 50);
        heading_label.setForeground(new Color(0, 42, 226));
        heading_label.setFont(new Font("Bodoni MT Black", Font.BOLD, 32));
        headPanel.add(heading_label);


        JLabel b=new JLabel();
        b.setBounds(20,85,900,450);
        b.setBorder(BorderFactory.createTitledBorder(""));
        b.setLayout(null);
        add(b);

        // name
        name_label = new JLabel("*Name:");
        name_label.setBounds(50, 100, 100, 30);
        name_label.setFont(new Font("serif", Font.PLAIN, 25));
        name_label.setForeground(Color.WHITE);
        add(name_label);

        //name-textfield
        namField = new JTextField();
        namField.setBounds(185, 20, 215, 30);
        namField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        namField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        namField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
                            namField.setEditable(true);
                            
                        }else{
                            namField.setEditable(false);
                        }
            }
            
        });
        b.add(namField);


        // father's name
        father_namelabel = new JLabel("*Father's Name:");
        father_namelabel.setBounds(470, 100, 200, 30);
        father_namelabel.setFont(new Font("serif", Font.PLAIN, 25));
        father_namelabel.setForeground(Color.WHITE);
        add(father_namelabel);

        //father's_name-textfield
        father_nameField = new JTextField();
        father_nameField.setBounds(660, 20, 215, 30);
        father_nameField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        b.add(father_nameField);

        father_name2 = new JLabel("");
        father_name2.setBounds(680, 128, 215, 30);
        father_name2.setFont(new Font("serif", Font.PLAIN, 17));
        father_name2.setForeground(new Color(255, 0, 0));
        add(father_name2);


        // roll
        roll_label = new JLabel("Roll:");
        roll_label.setBounds(50, 170, 200, 30);
        roll_label.setFont(new Font("serif", Font.PLAIN, 25));
        roll_label.setForeground(Color.WHITE);
        add(roll_label);

        roll2 = new JLabel("32801222" + first3);
        roll2.setBounds(205, 170, 250, 30);
        roll2.setFont(new Font("serif", Font.PLAIN, 25));
        roll2.setForeground(Color.WHITE);
        add(roll2);
 

        // dob
        dob_label = new JLabel("*Date of Birth:");
        dob_label.setBounds(470, 170, 200, 30);
        dob_label.setFont(new Font("serif", Font.PLAIN, 25));
        dob_label.setForeground(Color.WHITE);
        add(dob_label);

        //dob- chooser
        dateChooserdob = new JDateChooser();
        dateChooserdob.setBounds(660, 88, 215, 30);
        dateChooserdob.setFont(new Font("calibri", Font.PLAIN, 15));
        b.add(dateChooserdob);

        dob2 = new JLabel("");
        dob2.setBounds(680, 195, 215, 30);
        dob2.setFont(new Font("serif", Font.PLAIN, 17));
        dob2.setForeground(new Color(255, 0, 0));
        add(dob2);

         
      

        // address
        address_label = new JLabel("Address:");
        address_label.setBounds(50, 240, 200, 30);
        address_label.setFont(new Font("serif", Font.PLAIN, 25));
        address_label.setForeground(Color.WHITE);
        add(address_label);

        //address-textfield
        addressField = new JTextField();
        addressField.setBounds(185, 160, 215, 30);
        addressField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        b.add(addressField);


        //ph
        ph_label = new JLabel("*Phone Number: ");
        ph_label.setBounds(470, 240, 200, 30);
        ph_label.setFont(new Font("serif", Font.PLAIN, 25));
        ph_label.setForeground(Color.WHITE);
        add(ph_label);

        phField = new JTextField();
        phField.setBounds(660, 160, 215, 30);
        phField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        phField.setFont(new Font("calibri", Font.BOLD, 15));
        b.add(phField);
        
        ph2 = new JLabel("");
        ph2.setBounds(680, 268, 215, 30);
        ph2.setFont(new Font("serif", Font.PLAIN, 17));
        ph2.setForeground(new Color(255, 0, 0));
        add(ph2);


     


        // email
        email_label = new JLabel("*Email:");
        email_label.setBounds(50, 310, 200, 30);
        email_label.setFont(new Font("serif", Font.PLAIN, 25));
        email_label.setForeground(Color.WHITE);
        add(email_label);

        //email-textfield
        emailField = new JTextField();
        emailField.setBounds(185, 228, 215, 30);
        emailField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        
        b.add(emailField);


        //aadhar
        aadhar_nolabel = new JLabel("*Aadhar: ");
        aadhar_nolabel.setBounds(470, 310, 200, 30);
        aadhar_nolabel.setFont(new Font("serif", Font.PLAIN, 25));
        aadhar_nolabel.setForeground(Color.WHITE);
        add(aadhar_nolabel);

        aAdharField = new JTextField();
        aAdharField.setBounds(660, 225, 215, 30);
        aAdharField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        aAdharField.setFont(new Font("calibri", Font.PLAIN, 15));
        aAdharField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (Character.isDigit(c) ||Character.isWhitespace(c) || Character.isISOControl(c)) {
                            aAdharField.setEditable(true);
                            
                        }else{
                            aAdharField.setEditable(false);
                        }
            }
            
        });
        b.add(aAdharField);

        aAdhar2 = new JLabel("");
        aAdhar2.setBounds(680, 335, 215, 30);
        aAdhar2.setFont(new Font("serif", Font.PLAIN, 17));
        aAdhar2.setForeground(new Color(255, 0, 0));
        add(aAdhar2);


       
        // board_percentage
        board_percentagelabel = new JLabel("*Class X(%):");
        board_percentagelabel.setBounds(50, 380, 200, 30);
        board_percentagelabel.setFont(new Font("serif", Font.PLAIN, 25));
        board_percentagelabel.setForeground(Color.WHITE);
        add(board_percentagelabel);

        //board-textfield
        board_percentageField = new JTextField();
        board_percentageField.setBounds(185, 300, 215, 30);
        board_percentageField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        b.add(board_percentageField);

        
        


        //hs
        hs_percentagelabel = new JLabel("*Class XII (%):");
        hs_percentagelabel.setBounds(470, 380, 200, 30);
        hs_percentagelabel.setFont(new Font("serif", Font.PLAIN, 25));
        hs_percentagelabel.setForeground(Color.WHITE);
        add(hs_percentagelabel);

        hs_percentageField= new JTextField();
        hs_percentageField.setBounds(660, 298, 215, 30);
        hs_percentageField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        hs_percentageField.setFont(new Font("calibri", Font.PLAIN, 15));
        b.add(hs_percentageField);

        hs2= new JLabel("");
        hs2.setBounds(678, 408, 215, 30);
        hs2.setFont(new Font("serif", Font.PLAIN, 17));
        hs2.setForeground(new Color(255, 0, 0));
        add(hs2);





        
        // course
        course_label = new JLabel("*Course:");
        course_label.setBounds(50, 450, 200, 30);
        course_label.setFont(new Font("serif", Font.PLAIN, 25));
        course_label.setForeground(Color.WHITE);
        add(course_label);

        //course-textfield
        String course[]={"   ------------Select Option----------","BMLT", "BBA", "BCA", "B.Opt", "MBA"};
        cbCourse = new JComboBox(course);
        cbCourse.setBounds(205, 452, 215, 30);
        // cbCourse.setForeground(Color.RED);
        cbCourse.setBorder(BorderFactory.createEmptyBorder());
        add(cbCourse);

       
        
        //branch
        branch_label = new JLabel("*Branch:");
        branch_label.setBounds(470, 450, 200, 30);
        branch_label.setFont(new Font("serif", Font.PLAIN, 25));
        branch_label.setForeground(Color.WHITE);
        add(branch_label);

        //course-textfield
        String branch[]={"   ------------Select Option----------","Computer Science", "Mechanical", "Electrical", "Civil", "Mining"};
        cbBranch = new JComboBox(branch);
        cbBranch.setBackground(Color.WHITE);
        cbBranch.setBounds(680, 450, 215, 30);
        cbBranch.setBorder(BorderFactory.createEmptyBorder());
        add(cbBranch);


        branch2 = new JLabel("");
        branch2.setBackground(Color.WHITE);
        branch2.setBounds(680, 475, 215, 30);
        branch2.setFont(new Font("serif", Font.PLAIN, 17));
        branch2.setForeground(new Color(255, 0, 0));
         add(branch2);
 



     


      


       
        name2 = new JLabel("");
        name2.setBounds(205, 130, 215, 25);
        name2.setFont(new Font("serif", Font.PLAIN, 17));
        name2.setForeground(new Color(255, 0, 0));
        add(name2);

     




        email2 = new JLabel("");
        email2.setBounds(205, 342, 215, 25);
        email2.setFont(new Font("serif", Font.PLAIN, 17));
        email2.setForeground(new Color(255, 0, 0));
        add(email2);

      

        board2 = new JLabel("");
        board2.setBounds(205, 412, 215, 25);
        board2.setFont(new Font("serif", Font.PLAIN, 17));
        board2.setForeground(new Color(255, 0, 0));
        add(board2);

       

        course2 = new JLabel("");
        course2.setBounds(205, 482, 215, 25);
        course2.setFont(new Font("serif", Font.PLAIN, 17));
        course2.setForeground(new Color(255, 0, 0));
        add(course2);

      

        

       

       


       

        // Button-Submit
        submit = new JButton("Submit");
        submit.setBounds(250, 580, 100, 30);
        submit.setFont(new Font("Agency FB", Font.BOLD, 20));
        submit.setBackground(new Color(0, 214, 21));
        submit.setBorder(BorderFactory.createLineBorder(new Color(255,255,255,120)));
        submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submit.addActionListener(this);
        submit.setForeground(Color.WHITE);
        submit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                submit.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                submit.setBorder(BorderFactory.createLineBorder(new Color(255,255,255,120)));
            }
            
        });
        add(submit);
        // Button-Cancel
        cancel = new JButton("Cancel");
        cancel.setBounds(380, 580, 100, 30);
        cancel.setFont(new Font("Agency FB", Font.BOLD, 20));
        cancel.setBackground(Color.RED);
        cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cancel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255,120)));
        cancel.setForeground(Color.WHITE);
        cancel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                cancel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255,120)));
            }
            
        });
        cancel.addActionListener(this);
        add(cancel);
        // Button-Clear
        clear = new JButton("Clear");
        clear.setBounds(550, 580, 100, 30);
        clear.setFont(new Font("Agency FB", Font.BOLD, 20));
        clear.setBackground(Color.BLACK);
        clear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clear.setBorder(BorderFactory.createLineBorder(new Color(255,255,255,120)));
        clear.setForeground(Color.WHITE);
        clear.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                clear.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                clear.setBorder(BorderFactory.createLineBorder(new Color(255,255,255,120)));
            }
            
        });
        clear.addActionListener(this);
        add(clear);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddStudent().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
  
    if (e.getSource() == submit) {
        
        String name = namField.getText();
        String fname = father_nameField.getText();
        String roll = roll2.getText();
        String dob = ((JTextField)dateChooserdob.getDateEditor().getUiComponent()).getText();
        String address = addressField.getText();
        String ph = phField.getText();
        String email = emailField.getText();
        String board = board_percentageField.getText();
        String hs = hs_percentageField.getText();
        String aadhar = aAdharField.getText();
        String course = (String) cbCourse.getSelectedItem();
        String branch = (String) cbBranch.getSelectedItem();

        try {
           

            if (name.equals("") && fname.equals("") && dob.equals("") && address.equals("") && ph.equals("") && email.equals("") && board.equals("") && hs.equals("") && aadhar.equals("") && course.equals("   ------------Select Option----------") && branch.equals("   ------------Select Option----------")) {
                namField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                name2.setText("*required");

                father_nameField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                father_name2.setText("*required");

                dateChooserdob.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                dob2.setText("*required");

                aAdharField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                aAdhar2.setText("*required");

                phField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                ph2.setText("*required");

                emailField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                email2.setText("*required");

                board_percentageField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                board2.setText("*required");

                hs_percentageField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                hs2.setText("*required");

                cbCourse.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                course2.setText("*required");

                cbBranch.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                branch2.setText("*required");

                // namField.addKeyListener(new KeyAdapter() {

                //     @Override
                //     public void keyPressed(KeyEvent e) {
                //         // namField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
                //         // name2.setText("");
                //         char c = e.getKeyChar();
                //         if (Character.isLetter(c)) {
                //             namField.setEditable(true);
                            
                //         }else{
                //             namField.setEditable(false);
                //         }


                //     }
                    
                // });
                father_nameField.addKeyListener(new KeyAdapter() {

                    @Override
                    public void keyPressed(KeyEvent e) {
                            
                        father_nameField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
                        father_name2.setText("");
                    }
                    
                });
               
                dateChooserdob.addKeyListener(new KeyAdapter() {

                    @Override
                    public void keyPressed(KeyEvent e) {
                            
                        dateChooserdob.setBorder(BorderFactory.createLoweredSoftBevelBorder());
                        dob2.setText("");
                    }
                    
                });
                aAdharField.addKeyListener(new KeyAdapter() {

                    @Override
                    public void keyPressed(KeyEvent e) {
                            
                        aAdharField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
                        aAdhar2.setText("");
                    }
                    
                });
                phField.addKeyListener(new KeyAdapter() {

                    @Override
                    public void keyPressed(KeyEvent e) {
                            
                        phField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
                        ph2.setText("");
                    }
                    
                });
                emailField.addKeyListener(new KeyAdapter() {

                    @Override
                    public void keyPressed(KeyEvent e) {
                            
                        
                        emailField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
                        email2.setText("");
                    }
                    
                });
                board_percentageField.addKeyListener(new KeyAdapter() {

                    @Override
                    public void keyPressed(KeyEvent e) {
                            
                        
                        
                        board_percentageField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
                        board2.setText("");
                    }
                    
                });
                hs_percentageField.addKeyListener(new KeyAdapter() {

                    @Override
                    public void keyPressed(KeyEvent e) {
                            
                        
                        
                        hs_percentageField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
                        hs2.setText("");
                    }
                    
                });
                cbCourse.addKeyListener(new KeyAdapter() {

                    @Override
                    public void keyPressed(KeyEvent e) {
                            
                        
                       
                        cbCourse.setBorder(BorderFactory.createLoweredSoftBevelBorder());
                        course2.setText("");

                       
                    }
                    
                });
                cbBranch.addKeyListener(new KeyAdapter() {

                    @Override
                    public void keyPressed(KeyEvent e) {
                            
                        
                       
                       
                        cbBranch.setBorder(BorderFactory.createLoweredSoftBevelBorder());
                        branch2.setText("");
                    }
                    
                });
               
                
            }else if(!name.equals("") && fname.equals("") && dob.equals("") && address.equals("") && ph.equals("") && email.equals("") && board.equals("") && hs.equals("") && aadhar.equals("") && course.equals("------------Select Option----------") && branch.equals("------------Select Option----------")){
                // namField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                // name2.setText("*required");

                father_nameField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                father_name2.setText("*required");

                dateChooserdob.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                dob2.setText("*required");

                aAdharField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                aAdhar2.setText("*required");

                phField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                ph2.setText("*required");

                emailField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                email2.setText("*required");

                board_percentageField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                board2.setText("*required");

                hs_percentageField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                hs2.setText("*required");

                cbCourse.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                course2.setText("*required");

                cbBranch.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                branch2.setText("*required");

            }
            else{
                String query = "INSERT INTO student VALUES('"+name+"', '"+fname+"','"+roll+"','"+dob+"', '"+address+"','"+ph+"','"+email+"', '"+board+"', '"+hs+"', '"+aadhar+"', '"+course+"', '"+branch+"')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "<html><body style=\\'color:green;\\'><b>Student Details submitted successfully</b></body></html>");
                AddStudent.this.dispose();
            }

          


        } catch (Exception ex) {
           ex.printStackTrace();
        }

        
    }
    else if (e.getSource() == clear) {
       namField.setText(null);
       father_nameField.setText(null);
       aAdharField.setText(null);
       addressField.setText(null);
       emailField.setText(null);
       phField.setText(null);
       dateChooserdob.setCalendar(null);
       board_percentageField.setText(null);
       hs_percentageField.setText(null);
       cbCourse.setSelectedItem("   ------------Select Option----------");
       cbBranch.setSelectedItem("   ------------Select Option----------");
    }
    else if (e.getSource() == cancel) {
        AddStudent.this.dispose();
        
    }
       
    }

   
}
