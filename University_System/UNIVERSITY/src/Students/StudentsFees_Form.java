package Students;

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
import javax.swing.SwingUtilities;

import Database.Conn;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentsFees_Form extends JDialog implements ActionListener {
  JLabel name_label, namlabel, father_namelabel, father_name2, course_label, branch_label, lblsemester, lblTotal,
      labelTotal;
  Choice crollno;
  JComboBox cbBranch, cbCourse, cbsemester;
  JButton update, pay, back;

  public StudentsFees_Form() {
    setTitle("Fees");
    setSize(900, 500);
    setLocation(300, 100);
    setLayout(null);
    setModal(true);
    setResizable(false);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    getContentPane().setBackground(new Color(0, 15, 156));
    addComponents();

  }

  private void addComponents() {

    ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Images/MAKAUT.png"));
    Image i1 = image1.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
    ImageIcon i3 = new ImageIcon(i1);
    JLabel setimage1 = new JLabel(i3);
    setimage1.setBounds(470, 50, 350, 350);
    add(setimage1);

    JLabel lblroll = new JLabel("Select Roll number:");
    lblroll.setBounds(20, 38, 150, 50);
    lblroll.setForeground(Color.WHITE);
    lblroll.setFont(new Font("Calibri", Font.BOLD, 18));
    add(lblroll);

    crollno = new Choice();
    crollno.setBounds(190, 50, 150, 30);
    crollno.setFont(new Font("", Font.PLAIN, 12));
    // crollno.setBackground(Color.BLACK);
    crollno.setForeground(Color.BLACK);
    add(crollno);

    try {
      Conn conn = new Conn();
      ResultSet rs = conn.s.executeQuery("Select * From student");
      while (rs.next()) {
        crollno.add(rs.getString("roll"));

      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    // name
    name_label = new JLabel("Name:");
    name_label.setBounds(20, 100, 400, 50);
    name_label.setFont(new Font("serif", Font.BOLD, 20));
    name_label.setForeground(Color.WHITE);
    add(name_label);

    // name-textfield
    namlabel = new JLabel();
    namlabel.setBounds(155, 110, 250, 30);
    namlabel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
    namlabel.setForeground(Color.WHITE);
    namlabel.setFont(new Font("", Font.PLAIN, 18));
    add(namlabel);

    // father's name
    father_namelabel = new JLabel("Father's Name:");
    father_namelabel.setBounds(20, 150, 200, 50);
    father_namelabel.setFont(new Font("serif", Font.BOLD, 20));
    father_namelabel.setForeground(Color.WHITE);
    add(father_namelabel);

    // father's_name-textfield
    JLabel father_namelabel2 = new JLabel();
    father_namelabel2.setBounds(165, 160, 250, 30);
    father_namelabel2.setForeground(Color.WHITE);
    father_namelabel2.setFont(new Font("", Font.PLAIN, 18));
    add(father_namelabel2);

    try {
      Conn conn = new Conn();
      String query = "select * from student where roll = '" + crollno.getSelectedItem() + "'";
      ResultSet rs = conn.s.executeQuery(query);
      while (rs.next()) {
        namlabel.setText(rs.getString("name"));
        father_namelabel2.setText(rs.getString("fname"));

      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    crollno.addItemListener(new ItemListener() {

      @Override
      public void itemStateChanged(ItemEvent e) {

        try {
          Conn conn = new Conn();
          String query = "select * from student where roll = '" + crollno.getSelectedItem() + "'";
          ResultSet rs = conn.s.executeQuery(query);
          while (rs.next()) {
            namlabel.setText(rs.getString("name"));
            father_namelabel2.setText(rs.getString("fname"));

          }
        } catch (Exception ex) {
          ex.printStackTrace();
        }

      }

    });

    // course
    course_label = new JLabel("Course:");
    course_label.setBounds(20, 210, 150, 20);
    course_label.setFont(new Font("serif", Font.BOLD, 18));
    course_label.setForeground(Color.WHITE);
    add(course_label);

    // course-textfield
    String course[] = { "  ---- Select Option ----", "BMLT", "BBA", "BCA", "B.Opt", "MBA" };
    cbCourse = new JComboBox(course);
    cbCourse.setBounds(190, 210, 150, 20);
    cbCourse.setFont(new Font("Tahoma", Font.PLAIN, 12));
    add(cbCourse);

    // branch
    branch_label = new JLabel("Branch:");
    branch_label.setBounds(20, 250, 150, 20);
    branch_label.setFont(new Font("serif", Font.BOLD, 18));
    branch_label.setForeground(Color.WHITE);
    add(branch_label);

    // course-textfield
    String branch[] = { "  ---- Select Option ----", "Computer Science", "Mechanical", "Electrical", "Civil",
        "Mining" };
    cbBranch = new JComboBox(branch);
    cbBranch.setBackground(Color.WHITE);
    cbBranch.setBounds(190, 255, 150, 20);
    cbBranch.setFont(new Font("Tahoma", Font.PLAIN, 12));
    add(cbBranch);

    // semester
    lblsemester = new JLabel("Semester:");
    lblsemester.setBounds(20, 300, 150, 20);
    lblsemester.setForeground(Color.WHITE);
    lblsemester.setFont(new Font("serif", Font.BOLD, 18));
    add(lblsemester);

    String semester[] = { "Tution fee Sem1", "Tution fee Sem2", "Tution fee Sem3", "Tution fee Sem4", "Tution fee Sem5",
        "Tution fee Sem6", "Tution fee Sem7", "Tution fee Sem8" };
    cbsemester = new JComboBox(semester);
    cbsemester.setBounds(190, 303, 150, 20);
    cbsemester.setFont(new Font("Tahoma", Font.PLAIN, 12));
    add(cbsemester);

    // Total Payment
    lblTotal = new JLabel("Total Pay:");
    lblTotal.setBounds(20, 350, 150, 30);
    lblTotal.setForeground(Color.WHITE);
    lblTotal.setFont(new Font("serif", Font.BOLD, 20));
    add(lblTotal);

    // semester
    labelTotal = new JLabel();
    labelTotal.setBounds(180, 358, 150, 20);
    labelTotal.setForeground(new Color(250, 0, 36));
    labelTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
    add(labelTotal);

    // Button-Update
    update = new JButton("Update");
    update.setBounds(20, 400, 100, 30);
    update.setFont(new Font("Agency FB", Font.BOLD, 20));
    update.setBackground(new Color(0, 214, 21));
    update.setBorder(BorderFactory.createRaisedSoftBevelBorder());
    update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    update.addActionListener(this);
    update.setForeground(Color.WHITE);
    update.setFocusable(false);
    add(update);

    // Button-Pay
    pay = new JButton("Pay");
    pay.setBounds(180, 400, 100, 30);
    pay.setFont(new Font("Agency FB", Font.BOLD, 20));
    pay.setBackground(new Color(250, 0, 36));
    pay.setBorder(BorderFactory.createRaisedSoftBevelBorder());
    pay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    pay.addActionListener(this);
    pay.setForeground(Color.WHITE);
    pay.setFocusable(false);
    add(pay);

    // Button-Back
    back = new JButton("Back");
    back.setBounds(350, 400, 100, 30);
    back.setFont(new Font("Agency FB", Font.BOLD, 20));
    back.setBackground(new Color(0, 0, 0));
    back.setBorder(BorderFactory.createRaisedSoftBevelBorder());
    back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    back.addActionListener(this);
    back.setForeground(Color.WHITE);
    pay.setFocusable(false);
    add(back);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        new StudentsFees_Form().setVisible(true);
      }

    });
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == update) {
      String semester = (String) cbsemester.getSelectedItem();
      String course = (String) cbCourse.getSelectedItem();

      try {
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("SELECT * FROM fees_structure WHERE course='" + course + "'");
        while (rs.next()) {
          labelTotal.setText("Rs. " + rs.getString(semester));

        }
      } catch (Exception exp) {
        exp.printStackTrace();
      }
    } else if (e.getSource() == pay) {
     
      String rollNo = crollno.getSelectedItem();
      String semester = (String) cbsemester.getSelectedItem();
      String course = (String) cbCourse.getSelectedItem();
      String branch = (String) cbBranch.getSelectedItem();
      String total = labelTotal.getText();
      if (course.equals("  ---- Select Option ----") && branch.equals("  ---- Select Option ----")) {
        JOptionPane.showMessageDialog(null,
            "<html><body style=\'color:red;\'>Please Enter your course and branch</body></html>");
        // this.setVisible(false);
      }else{
        try {
          Conn conn = new Conn();
          String query = "INSERT INTO collegefee VALUES ('" + rollNo + "', '" + course + "', '" + branch + "', '"
              + semester + "', '" + total + "')";
          conn.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null,
              "<html><body style=\'color:green;\'>Semester Fee Submitted Successfully</body></html>");
          this.setVisible(false);
        } catch (Exception exp) {
          exp.printStackTrace();
        }
      }
      
    } else {
      this.dispose();
    }
  }
}
