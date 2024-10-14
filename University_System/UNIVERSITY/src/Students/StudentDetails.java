package Students;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.table.TableColumn;

import java.sql.ResultSet;
// import net.proteanit.sql.DbUtils;
import Database.Conn;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JDialog implements ActionListener{
    private Choice crollno;
    private JTable Table;
    private JButton search, print, update, add, cancel;

    public StudentDetails() {
        setTitle("View Details (Student)");
        setSize(1200, 700);
        setLocation(200, 100);
        getContentPane().setBackground(new Color(60, 60, 60));
        setResizable(false);
        setLayout(null);
        setModal(true);
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
            ResultSet rs = conn.s.executeQuery("Select * From student");
            while (rs.next()) {
                crollno.add(rs.getString("roll"));
                
            }
        } catch (Exception e) {
           e.printStackTrace();
        }

        Table = new JTable();
       
       
     
       
        
        

        try {
            Conn conn = new Conn(); 
            ResultSet rs = conn.s.executeQuery("Select * From student");
          Table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
           e.printStackTrace();
        }

        
        
        JScrollPane scrollPane = new JScrollPane(Table);
        scrollPane.setBounds(0, 100, 1200, 700);
        add(scrollPane);

        JTableHeader tHeader = Table.getTableHeader();
        tHeader.setBackground(new Color(66, 165, 245));
        tHeader.setForeground(Color.WHITE);
        tHeader.setFont(new Font("Tahoma", Font.BOLD, 12));
        ((DefaultTableCellRenderer)tHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);

        TableColumn col1 = Table.getColumnModel().getColumn(0);
        col1.setPreferredWidth(600);
        
        TableColumn col2 = Table.getColumnModel().getColumn(1);
        col2.setPreferredWidth(600);

        TableColumn col3 = Table.getColumnModel().getColumn(2);
        col3.setPreferredWidth(330);

        TableColumn col4 = Table.getColumnModel().getColumn(3);
        col4.setPreferredWidth(280);

        TableColumn col5 = Table.getColumnModel().getColumn(4);
        col5.setPreferredWidth(320);

        TableColumn col6 = Table.getColumnModel().getColumn(5);
        col6.setPreferredWidth(320);

        TableColumn col7 = Table.getColumnModel().getColumn(6);
        col7.setPreferredWidth(400);

        TableColumn col8 = Table.getColumnModel().getColumn(7);
        col8.setPreferredWidth(130);

        TableColumn col9 = Table.getColumnModel().getColumn(8);
        col9.setPreferredWidth(120);

        TableColumn col10 = Table.getColumnModel().getColumn(9);
        col10.setPreferredWidth(420);

        TableColumn col11 = Table.getColumnModel().getColumn(10);
        col11.setPreferredWidth(180);

        TableColumn col12 = Table.getColumnModel().getColumn(11);
        col12.setPreferredWidth(400);



        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        search.setBackground(new Color(11, 11, 11));
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Arial", Font.BOLD, 12));
        search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(140,70,80,20);
        print.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        print.setBackground(Color.BLUE);
        print.setForeground(Color.WHITE);
        print.setFont(new Font("Arial", Font.BOLD, 12));
        print.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        print.addActionListener(this);
        add(print);

        add = new JButton("Add+");
        add.setBounds(260,70,80,20);
        add.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        add.setBackground(new Color(38, 227, 0));
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Arial", Font.BOLD, 12));
        add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(380,70,80,20);
        update.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        update.setBackground(new Color(227, 163, 0));
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Arial", Font.BOLD, 12));
        update.addActionListener(this);
        update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(500,70,80,20);
        cancel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        cancel.setBackground(new Color(220, 0, 0));
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Arial", Font.BOLD, 12));
        cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cancel.addActionListener(this);
        add(cancel);

    }

    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
        @Override public void run(){
            new StudentDetails().setVisible(true);
        }
       });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if (e.getSource() == search) {
        String query = "Select * From student Where roll='"+crollno.getSelectedItem()+"'";
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
     }else if (e.getSource() == add) {
        this.dispose();
        new AddStudent().setVisible(true);
        
     }else if (e.getSource() == update) {
        this.dispose();
        new UpdateStudent_Details().setVisible(true);
        
     }else{
   
    this.dispose();
     }
    }

}
