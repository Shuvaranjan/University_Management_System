import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import Students.AddStudent;
import Students.Examination_Details;
import Students.FeesStructure;
import Students.StudentDetails;
import Students.StudentLeave;
import Students.StudentLeaveDetails;
import Students.StudentsFees_Form;
import Students.UpdateStudent_Details;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Project extends JFrame implements ActionListener{
    public Project(){
        setTitle("Makaut W.B.");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(2000,900);
        getContentPane().setBackground(new Color(255, 236, 0));
        setResizable(false);
        
        

        addComponents();
    }
    private void addComponents() {
        
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("Images/M.png"));
        this.setIconImage(icon.getImage());


        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Images/Books2.jpg"));
        Image i1 = image1.getImage().getScaledInstance(1522, 810, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i1);
        JLabel setimage1 = new JLabel(i3);
        add(setimage1);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(BorderFactory.createEmptyBorder());
        menuBar.setBackground(new Color(0, 125, 255));

        //New Information
        JMenu newInformation = new JMenu("New Information  |");
        newInformation.setForeground(Color.WHITE);
        newInformation.setBorder(BorderFactory.createEmptyBorder());
        newInformation.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                newInformation.setForeground(Color.RED);
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
                newInformation.setForeground(Color.WHITE);
               
            }
            
        });
        menuBar.add(newInformation);
        setJMenuBar(menuBar);


        JMenuItem studentInfo = new JMenuItem("New Student Details");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.setForeground(Color.BLACK);
        studentInfo.addActionListener(this);
        studentInfo.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        newInformation.add(studentInfo);

        //View Details
        JMenu details = new JMenu("View Details  |");
        details.setForeground(Color.WHITE);
        details.setBorder(BorderFactory.createEmptyBorder());
        details.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                details.setForeground(Color.RED);
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
                details.setForeground(Color.WHITE);
               
            }
            
        });
        menuBar.add(details);
        setJMenuBar(menuBar);

        

   

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.setForeground(Color.BLACK);
        studentDetails.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        studentDetails.addActionListener(this);
        details.add(studentDetails);
      
        //leave
        JMenu leave = new JMenu("Apply Leave  |");
        leave.setForeground(Color.WHITE);
        leave.setBorder(BorderFactory.createEmptyBorder());
        leave.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                leave.setForeground(Color.RED);
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
                leave.setForeground(Color.WHITE);
               
            }
            
        });
        menuBar.add(leave);
        setJMenuBar(menuBar);

        


        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.setForeground(Color.BLACK);
        studentLeave.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        //leave details
        JMenu leaveDetails = new JMenu("Leave Details  |");
        leaveDetails.setForeground(Color.WHITE);
        leaveDetails.setBorder(BorderFactory.createEmptyBorder());
        leaveDetails.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                leaveDetails.setForeground(Color.RED);
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
                leaveDetails.setForeground(Color.WHITE);
               
            }
            
        });
        menuBar.add(leaveDetails);
        setJMenuBar(menuBar);

        


        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.WHITE);
        studentLeaveDetails.setForeground(Color.BLACK);
        studentLeaveDetails.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        //exam
        JMenu exam = new JMenu("Examination  |");
        exam.setForeground(Color.WHITE);
        exam.setBorder(BorderFactory.createEmptyBorder());
        exam.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                exam.setForeground(Color.RED);
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exam.setForeground(Color.WHITE);
               
            }
            
        });
        menuBar.add(exam);
        setJMenuBar(menuBar);

        

        JMenuItem examinationDetails = new JMenuItem("Examination Results");
        examinationDetails.setBackground(Color.WHITE);
        examinationDetails.setForeground(Color.BLACK);
        examinationDetails.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);


        //updateInfo
        JMenu updateInfo = new JMenu("Update Details  |");
        updateInfo.setForeground(Color.WHITE);
        updateInfo.setBorder(BorderFactory.createEmptyBorder());
        updateInfo.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                updateInfo.setForeground(Color.RED);
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
                updateInfo.setForeground(Color.WHITE);
               
            }
            
        });
        menuBar.add(updateInfo);
        setJMenuBar(menuBar);

        


        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
        updateStudentInfo.setBackground(Color.WHITE);
        updateStudentInfo.setForeground(Color.BLACK);
        updateStudentInfo.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);

        //fees
        JMenu fees = new JMenu("Fees Details  |");
        fees.setForeground(Color.WHITE);
        fees.setBorder(BorderFactory.createEmptyBorder());
        fees.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                fees.setForeground(Color.RED);
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
                fees.setForeground(Color.WHITE);
               
            }
            
        });
        menuBar.add(fees);
        setJMenuBar(menuBar);

        

        JMenuItem feesStructure = new JMenuItem("Fees Structure");
        feesStructure.setBackground(Color.WHITE);
        feesStructure.setForeground(Color.BLACK);
        feesStructure.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        feesStructure.addActionListener(this);
        fees.add(feesStructure);

        JMenuItem feeForm = new JMenuItem("Student Fees Form");
        feeForm.setBackground(Color.WHITE);
        feeForm.setForeground(Color.BLACK);
        feeForm.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        feeForm.addActionListener(this);
        fees.add(feeForm);

        //utility
        JMenu utility = new JMenu("Utility  |");
        utility.setForeground(Color.WHITE);
        utility.setBorder(BorderFactory.createEmptyBorder());
        utility.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                utility.setForeground(Color.RED);
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
                utility.setForeground(Color.WHITE);
               
            }
            
        });
        menuBar.add(utility);
        setJMenuBar(menuBar);

        

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.setForeground(Color.BLACK);
        notepad.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.setForeground(Color.BLACK);
        calculator.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        calculator.addActionListener(this);
        utility.add(calculator);

        //exit
        JMenu Exit = new JMenu("Exit");
        Exit.setForeground(Color.WHITE);
        Exit.setBorder(BorderFactory.createEmptyBorder());
        Exit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                Exit.setForeground(Color.RED);
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Exit.setForeground(Color.WHITE);
               
            }
            
        });
        menuBar.add(Exit);
        setJMenuBar(menuBar);

        

        JMenuItem exit = new JMenuItem("exit");
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        exit.addActionListener(this);
        Exit.add(exit);
        

      


    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Project().setVisible(true);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
    
       
        if (msg.equals("exit")) {
            Project.this.dispose();
            new Dasboard().setVisible(true);
            
        }else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception evt) {
               evt.printStackTrace();
            }
            
        }else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception evt) {
                evt.printStackTrace();
            }
            
        }
        else if (msg.equals("New Student Details")) {
            new AddStudent().setVisible(true);
        }
        else if (msg.equals("View Student Details")) {
            new StudentDetails().setVisible(true);
        }
        else if (msg.equals("Student Leave")) {
            new StudentLeave().setVisible(true);
        }else if (msg.equals("Student Leave Details")) {
            new StudentLeaveDetails().setVisible(true);
            
        }
        else if (msg.equals("Update Student Details")) {
            new UpdateStudent_Details().setVisible(true);
            
        }else if (msg.equals("Examination Results")) {
            new Examination_Details().setVisible(true);
            
        }else if (msg.equals("Fees Structure")) {
            new FeesStructure().setVisible(true);
            
        }else if (msg.equals("Student Fees Form")) {
            new StudentsFees_Form().setVisible(true);
            
        }
       
    }
    
}
