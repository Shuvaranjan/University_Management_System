package Faculty_Members;




import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import java.sql.ResultSet;
import Database.Conn;
import net.proteanit.sql.DbUtils;

public class TeacherLeaveDetails extends JDialog implements ActionListener{
    private Choice crollno;
    private JTable Table;
    private JButton search, print, cancel;

    public TeacherLeaveDetails() {
        setTitle("Leave Details(Faculty)");
        setSize(900, 700);
        setLocation(300, 100);
        setModal(true);
        getContentPane().setBackground(new Color(60, 60, 60));
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addComponents();

    }

    private void addComponents() {

        JLabel heading = new JLabel("Search by Roll number:");
        heading.setBounds(20, 22, 150, 20);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Calibri", Font.BOLD, 15));
        add(heading);

        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        // crollno.setBackground(Color.WHITE);
        add(crollno);




        try {
            Conn conn = new Conn(); 
            ResultSet rs = conn.s.executeQuery("Select * From teacher_leave");
            while (rs.next()) {
                crollno.add(rs.getString("empID"));
                
            }
        } catch (Exception e) {
           e.printStackTrace();
        }

        Table = new JTable();
     
       
        
        

        try {
            Conn conn = new Conn(); 
            ResultSet rs = conn.s.executeQuery("Select * From teacher_leave");
          Table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
           e.printStackTrace();
        }

        
        
        JScrollPane scrollPane = new JScrollPane(Table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 100, 900, 700);
        add(scrollPane);

          JTableHeader tHeader = Table.getTableHeader();
        tHeader.setBackground(new Color(0,0,0));
        tHeader.setForeground(Color.WHITE);
        tHeader.setFont(new Font("Tahoma", Font.BOLD, 12));
        ((DefaultTableCellRenderer)tHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        search.setBackground(new Color(11, 11, 11));
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Arial", Font.BOLD, 12));
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(140,70,80,20);
        print.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        print.setBackground(Color.BLUE);
        print.setForeground(Color.WHITE);
        print.setFont(new Font("Arial", Font.BOLD, 12));
        print.addActionListener(this);
        add(print);

        cancel = new JButton("Cancel");
        cancel.setBounds(250,70,80,20);
        cancel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        cancel.setBackground(new Color(220, 0, 0));
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Arial", Font.BOLD, 12));
        cancel.addActionListener(this);
        add(cancel);

    }

    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
        @Override public void run(){
            new TeacherLeaveDetails().setVisible(true);
        }
       });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if (e.getSource() == search) {
        String query = "Select * From teacher_leave Where empID ='"+crollno.getSelectedItem()+"'";
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery(query);
            Table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ae) {
           ae.printStackTrace();
        }
        
     }else if (e.getSource() == print) {
        try {
            Table.print();
        } catch (Exception ae) {
            ae.printStackTrace();
        }
     }else{
   
    this.dispose();
     }
    }

}

