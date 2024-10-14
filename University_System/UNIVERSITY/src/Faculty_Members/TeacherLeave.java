package Faculty_Members;



import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

import com.toedter.calendar.JDateChooser;

import Database.Conn;

public class TeacherLeave extends JDialog implements ActionListener{
    JLabel heading, lblEmpID, lbldate, lbltime;
    JPanel panel;
    Choice cEmpID, ctime;
    JDateChooser dateChooser;
    JButton submit, cancel;

    public TeacherLeave() {
        setTitle("Teacher Leave");
        setSize(500, 550);
        setLocation(550, 100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(new Color(36, 36, 36));

        addComponents();
    }

    private void addComponents() {

        panel = new JPanel();
        panel.setBounds(0, 20, 500, 50);
        panel.setBackground(new Color(250, 0, 36));
        panel.setLayout(null);
        add(panel);

        heading = new JLabel("Apply Leave(Teacher)");
        heading.setBounds(120, 0, 300, 50);
        // heading.setForeground(Color.WHITE);
        heading.setForeground(new Color(36, 36, 36));
        heading.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        panel.add(heading);

        lblEmpID = new JLabel("Search by Employee ID");
        lblEmpID.setBounds(20, 100, 200, 20);
        lblEmpID.setForeground(Color.WHITE);
        lblEmpID.setFont(new Font("Calibri", Font.BOLD, 18));
        add(lblEmpID);

        cEmpID = new Choice();
        cEmpID.setBounds(20, 125, 200, 20);
        cEmpID.setBackground(new Color(112, 231, 255));
        add(cEmpID);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * From faculty");
            while (rs.next()) {
                cEmpID.add(rs.getString("empID"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        lbldate = new JLabel("Date");
        lbldate.setBounds(20, 180, 150, 20);
        lbldate.setForeground(Color.WHITE);
        lbldate.setFont(new Font("Calibri", Font.BOLD, 18));
        add(lbldate);

        ctime = new Choice();
        ctime.setBounds(20, 285, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        lbltime = new JLabel("Time Duration");
        lbltime.setBounds(20, 260, 200, 20);
        lbltime.setForeground(Color.WHITE);
        lbltime.setFont(new Font("Calibri", Font.BOLD, 18));
        add(lbltime);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(20, 205, 200, 20);
        add(dateChooser);

        submit = new JButton("Submit");
        submit.setBounds(20, 350, 80, 30);
        submit.setForeground(new Color(255,255,255,85));
        submit.setFont(new Font("Arial", Font.BOLD, 12));
        submit.setBackground(new Color(0, 0, 0));
        submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submit.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  new Color(0, 191, 230,150), new Color(72, 231, 0,150)));
        submit.addActionListener(this);
        submit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                submit.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, new Color(72, 231, 0,150), new Color(0, 191, 230,150)));
                submit.setForeground(new Color(255,255,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                submit.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  new Color(0, 191, 230,150), new Color(72, 231, 0,150)));
                submit.setForeground(new Color(255,255,255,85));
            }
            
        });
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(120, 350, 80, 30);
        cancel.setForeground(new Color(255,255,255,85));
        cancel.setFont(new Font("Arial", Font.BOLD, 12));
        cancel.setBackground(new Color(0, 0, 0));
        cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cancel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, new Color(239, 0, 0,180), new Color(0, 191, 230,150)));
        cancel.addActionListener(this);
        cancel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                cancel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, new Color(0, 191, 230,150), new Color(239, 0, 0,180)));
                cancel.setForeground(new Color(255,255,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, new Color(239, 0, 0,180), new Color(0, 191, 230,150)));
                cancel.setForeground(new Color(255,255,255,85));
            }
            
        });
        add(cancel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TeacherLeave().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == submit) {
        String empID = cEmpID.getSelectedItem();
        String date = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String duration = ctime.getSelectedItem();

        //query
        String query = "Insert Into teacher_leave Values('"+empID+"', '"+date+"', '"+duration+"')";
        try {
            Conn conn = new Conn();
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Leave Confirmed");
            setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
      }else{
        this.dispose();
      }
    }
}
