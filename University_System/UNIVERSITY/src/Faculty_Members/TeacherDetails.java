package Faculty_Members;

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

import java.sql.ResultSet;
// import net.proteanit.sql.DbUtils;
import Database.Conn;
import net.proteanit.sql.DbUtils;

public class TeacherDetails extends JDialog implements ActionListener {
    private Choice cempID;
    private JTable Table;
    private JButton search, print, update, add, cancel;

    public TeacherDetails() {
        setTitle("View Details (Faculty)");
        setSize(900, 700);
        setLocation(300, 100);
        getContentPane().setBackground(new Color(60, 60, 60));
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);


        addComponents();

    }

    private void addComponents() {

        JLabel heading = new JLabel("Search by Employee ID:");
        heading.setBounds(20, 22, 150, 20);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Calibri", Font.BOLD, 15));
        add(heading);

        cempID = new Choice();
        cempID.setBounds(180, 20, 150, 20);
        // crollno.setBackground(Color.WHITE);
        add(cempID);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * From faculty");
            while (rs.next()) {
                cempID.add(rs.getString("empID"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Table = new JTable();

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * From faculty");
            Table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(Table);
        scrollPane.setBounds(0, 100, 900, 700);
        add(scrollPane);

        JTableHeader tHeader = Table.getTableHeader();
        tHeader.setBackground(new Color(255,0,36));
        tHeader.setForeground(Color.WHITE);
        tHeader.setFont(new Font("Tahoma", Font.BOLD, 12));
        ((DefaultTableCellRenderer)tHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        search.setBackground(new Color(11, 11, 11));
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Arial", Font.BOLD, 12));
        search.addActionListener(this);
        search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(search);

        print = new JButton("Print");
        print.setBounds(140, 70, 80, 20);
        print.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        print.setBackground(Color.BLUE);
        print.setForeground(Color.WHITE);
        print.setFont(new Font("Arial", Font.BOLD, 12));
        print.addActionListener(this);
        print.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(print);

        add = new JButton("Add+");
        add.setBounds(260, 70, 80, 20);
        add.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        add.setBackground(new Color(38, 227, 0));
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Arial", Font.BOLD, 12));
        add.addActionListener(this);
        add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(add);

        update = new JButton("Update");
        update.setBounds(380, 70, 80, 20);
        update.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        update.setBackground(new Color(227, 163, 0));
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Arial", Font.BOLD, 12));
        update.addActionListener(this);
        update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(500, 70, 80, 20);
        cancel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        cancel.setBackground(new Color(220, 0, 0));
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Arial", Font.BOLD, 12));
        cancel.addActionListener(this);
        cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(cancel);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TeacherDetails().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String query = "Select * From faculty Where empID ='" + cempID.getSelectedItem() + "'";
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                Table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else if (e.getSource() == print) {
            try {
                Table.print();
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == add) {
            this.dispose();
            new AddTeacher().setVisible(true);

        } else if (e.getSource() == update) {
            this.dispose();
            new UpdateTeacher_Details().setVisible(true);

        } else {
            this.dispose();
        }
    }

}
