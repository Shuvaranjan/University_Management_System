import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import Faculty_Members.AddTeacher;
import Faculty_Members.Enter_Marks;
import Faculty_Members.TeacherDetails;
import Faculty_Members.TeacherLeave;
import Faculty_Members.TeacherLeaveDetails;
import Faculty_Members.UpdateTeacher_Details;
import Students.AddStudent;
import Students.Examination_Details;
import Students.StudentDetails;
import Students.StudentLeave;
import Students.StudentLeaveDetails;
import Students.UpdateStudent_Details;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Project2 extends JFrame implements ActionListener{
    public Project2(){
        setTitle("Makaut W.B.");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // setSize(1600,800);
        getContentPane().setBackground(new Color(255, 236, 0));
        setResizable(false);
     
       
        addComponents();
    }
    private void addComponents() {
        
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("Images/M.png"));
        this.setIconImage(icon.getImage());
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Images/M.jpg"));
        Image i1 = image1.getImage().getScaledInstance(1520, 800, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i1);
        JLabel setimage1 = new JLabel(i3);
        setimage1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                getContentPane().setBackground(new Color(255, 0, 0));
            }
            public void mouseExited(MouseEvent e) {
                getContentPane().setBackground(new Color(255, 236, 0));
            }
            
        });
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

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.setForeground(Color.BLACK);
        facultyInfo.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        facultyInfo.addActionListener(this);
        facultyInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        newInformation.add(facultyInfo);

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

        

        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.setForeground(Color.BLACK);
        facultyDetails.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        facultyDetails.addActionListener(this);
        facultyDetails.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.setForeground(Color.BLACK);
        studentDetails.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        studentDetails.addActionListener(this);
        studentDetails.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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

        

        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.setForeground(Color.BLACK);
        facultyLeave.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        facultyLeave.addActionListener(this);
        facultyLeave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        leave.add(facultyLeave);


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

        

        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        facultyLeaveDetails.setForeground(Color.BLACK);
        facultyLeaveDetails.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        facultyLeaveDetails.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.WHITE);
        studentLeaveDetails.setForeground(Color.BLACK);
        studentLeaveDetails.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        studentLeaveDetails.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
        examinationDetails.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exam.add(examinationDetails);

        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setBackground(Color.WHITE);
        enterMarks.setForeground(Color.BLACK);
        enterMarks.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        enterMarks.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        enterMarks.addActionListener(this);
        exam.add(enterMarks);

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

        

        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Details");
        updateFacultyInfo.setBackground(Color.WHITE);
        updateFacultyInfo.setForeground(Color.BLACK);
        updateFacultyInfo.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        updateFacultyInfo.addActionListener(this);
        updateFacultyInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateInfo.add(updateFacultyInfo);


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

        //fees
        JMenu  about= new JMenu("About  |");
        about.setForeground(Color.WHITE);
        about.setBorder(BorderFactory.createEmptyBorder());
        about.addMouseListener(new MouseAdapter() {
   
               @Override
               public void mouseEntered(MouseEvent e) {
                   about.setForeground(Color.RED);
                  
               }
   
               @Override
               public void mouseExited(MouseEvent e) {
                   about.setForeground(Color.WHITE);
                  
               }
               
           });
           menuBar.add(about);
           setJMenuBar(menuBar);

        JMenuItem About = new JMenuItem("about");
        About.setBackground(Color.WHITE);
        About.setForeground(Color.BLACK);
        About.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        About.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        About.addActionListener(this);
        about.add(About);
        

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.setForeground(Color.BLACK);
        notepad.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        notepad.addActionListener(this);
        notepad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.setForeground(Color.BLACK);
        calculator.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
        calculator.addActionListener(this);
        calculator.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
        exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Exit.add(exit);
        

      


    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Project2().setVisible(true);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
    
       
        if (msg.equals("exit")) {
            Project2.this.dispose();
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
        else if (msg.equals("New Faculty Information")) {
            new AddTeacher().setVisible(true);
        }
        else if (msg.equals("View Faculty Details")) {
            new TeacherDetails().setVisible(true);
        }
        else if (msg.equals("View Student Details")) {
            new StudentDetails().setVisible(true);
        }
        else if (msg.equals("Faculty Leave")) {
            new TeacherLeave().setVisible(true);
        }else if (msg.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails().setVisible(true);
            
        }else if (msg.equals("Student Leave Details")) {
            new StudentLeaveDetails().setVisible(true);
            
        }
        else if (msg.equals("Update Faculty Details")) {
            new UpdateTeacher_Details().setVisible(true);
            
        }else if (msg.equals("Enter Marks")) {
            new Enter_Marks().setVisible(true);
        }else if (msg.equals("Examination Results")) {
            new Examination_Details().setVisible(true);
            
        }else if (msg.equals("about")) {
            new About().setVisible(true);
            
        }
       
    }
    
}
