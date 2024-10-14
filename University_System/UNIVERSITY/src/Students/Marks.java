package Students;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import Database.Conn;

public class Marks extends JDialog implements ActionListener{
    private String rollno;
    private JLabel heading, subheading, lblrollno, lblsemester;
    private JLabel subj1, subj2, subj3, subj4, subj5;
    private JLabel marks1, marks2, marks3, marks4, marks5;
    private JPanel panel;
    private JButton print, cancel;

    public Marks(String rollno) {
        this.rollno = rollno;
        setTitle("Makaut W.B.");
        setSize(500, 600);
        setLocation(500, 100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setModal(true);
        setVisible(true);

        getContentPane().setBackground(new Color(0, 33, 236));
        addComponents();

    }

    private void addComponents() {

        panel = new JPanel();
        panel.setBounds(0,45,500,40);
        panel.setLayout(null);
        panel.setBackground(new Color(0,0,0,150));
        add(panel);


        heading = new JLabel("Makaut W.B.");
        heading.setBounds(170, 10, 500, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setForeground(new Color(255, 251, 0));
        add(heading);

        subheading = new JLabel("Result of the Examination 2024");
        subheading.setBounds(100, 10, 500, 25);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        subheading.setForeground(new Color(255, 251, 0,200));
        panel.add(subheading);

        lblrollno = new JLabel("Roll Numnber: " + rollno);
        lblrollno.setBounds(20, 100,500,20);
        lblrollno.setForeground(new Color(255,255,255));
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);

        lblsemester = new JLabel("");
        lblsemester.setBounds(20, 135,500,20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblsemester.setForeground(new Color(255,255,255));
        add(lblsemester);

        JLabel sLabel = new JLabel("Subject");
        sLabel.setBounds(100,180,100,50);
        sLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        sLabel.setForeground(new Color(255,255,255,120));
        add(sLabel);
        //Subjects
        subj1 = new JLabel();
        subj1.setBounds(30, 230,500,20);
        subj1.setFont(new Font("Tahoma", Font.BOLD, 18));
        subj1.setForeground(new Color(255,255,255));
        add(subj1);

        subj2 = new JLabel();
        subj2.setBounds(30, 260,500,20);
        subj2.setFont(new Font("Tahoma", Font.BOLD, 18));
        subj2.setForeground(new Color(255,255,255));
        add(subj2);

        subj3= new JLabel();
        subj3.setBounds(30, 290,500,20);
        subj3.setFont(new Font("Tahoma", Font.BOLD, 18));
        subj3.setForeground(new Color(255,255,255));
        add(subj3);

        subj4 = new JLabel();
        subj4.setBounds(30, 320,500,20);
        subj4.setFont(new Font("Tahoma", Font.BOLD, 18));
        subj4.setForeground(new Color(255,255,255));
        add(subj4);

        subj5 = new JLabel();
        subj5.setBounds(30, 350,500,20);
        subj5.setFont(new Font("Tahoma", Font.BOLD, 18));
        subj5.setForeground(new Color(255,255,255));
        add(subj5);

        JLabel mLabel = new JLabel("Marks");
        mLabel.setBounds(350,180,100,50);
        mLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        mLabel.setForeground(new Color(255,255,255,120));
        add(mLabel);

        //Marks
        marks1 = new JLabel();
        marks1.setBounds(380, 230,500,20);
        marks1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        marks1.setForeground(new Color(255, 251, 0));
        add(marks1);

        marks2 = new JLabel();
        marks2.setBounds(380, 260,500,20);
        marks2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        marks2.setForeground(new Color(255, 251, 0));
        add(marks2);

        marks3 = new JLabel();
        marks3.setBounds(380, 290,500,20);
        marks3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        marks3.setForeground(new Color(255, 251, 0));
        add(marks3);

        marks4 = new JLabel();
        marks4.setBounds(380, 320,500,20);
        marks4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        marks4.setForeground(new Color(255, 251, 0));
        add(marks4);

        marks5 = new JLabel();
        marks5.setBounds(380, 350,500,20);
        marks5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        marks5.setForeground(new Color(255, 251, 0));
        add(marks5);



        try {
            Conn con = new Conn();
            ResultSet rs1 = con.s.executeQuery("SELECT * FROM subject WHERE rollno = '"+rollno+"'");
            while (rs1.next()) {
                subj1.setText(rs1.getString("subject1"));
                subj2.setText(rs1.getString("subject2"));
                subj3.setText(rs1.getString("subject3"));
                subj4.setText(rs1.getString("subject4"));
                subj5.setText(rs1.getString("subject5"));
                
            }

            ResultSet rs2 = con.s.executeQuery("SELECT * FROM marks WHERE rollno = '"+rollno+"'");
            while (rs2.next()) {
                marks1.setText(rs2.getString("marks1"));
                marks2.setText(rs2.getString("marks2"));
                marks3.setText(rs2.getString("marks3"));
                marks4.setText(rs2.getString("marks4"));
                marks5.setText(rs2.getString("marks5"));
                lblsemester.setText("Semester: " + rs2.getString("semester"));
            }

        } catch (Exception e) {
           e.printStackTrace();
        }


        cancel = new JButton("Back");
        cancel.setBounds(100, 420, 85, 30);
        cancel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        cancel.setBackground(new Color(220, 0, 0));
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Arial", Font.BOLD, 15));
        cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cancel.addActionListener(this);
        add(cancel);

    }

    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run(){
            new Marks(null).setVisible(true);
        }
       });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   String btn = e.getActionCommand();
   if(btn.equals("Back")){
    this.dispose();
    new Examination_Details().setVisible(true);
   }
    }
}
