package Students;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;
import Database.Conn;

public class FeesStructure extends JDialog implements ActionListener{
    JTable table;
    JPanel panel;
    public FeesStructure(){
        setTitle("Makaut W.B.");
        setSize(1400,700);
        setLocation(80,50);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setModal(true);
        getContentPane().setBackground(new Color(47, 47, 47));


        addComponents();

        
    }
    private void addComponents(){

        panel = new JPanel();
        panel.setBounds(0,8,350,45);
        panel.setBackground(new Color(255,0,0, 120));
        panel.setBorder(BorderFactory.createMatteBorder(1,0,1,1,new Color(255,0,0,85)));
        panel.setLayout(null);
        add(panel);
        JLabel heading = new JLabel("Fees Structure");
        heading.setBounds(75,0,400,40);
        heading.setForeground(new Color(255, 255, 255));
        heading.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        panel.add(heading);
        
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN,15));
        // table.setShowHorizontalLines(false);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM fees_structure");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
          e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 60, 1400, 700);
        add(jsp);

        JTableHeader tHeader = table.getTableHeader();
        tHeader.setBackground(new Color(66, 165, 245));
        tHeader.setForeground(Color.WHITE);
        tHeader.setFont(new Font("Tahoma", Font.BOLD, 12));
        ((DefaultTableCellRenderer)tHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);

        JButton print = new JButton("Print");
        print.setBounds(1200, 10, 85, 30);
        print.setBackground(new Color(255, 0, 0));
        print.setForeground(Color.WHITE);
        print.setFocusable(false);
        print.setFont(new Font("Tahoma", Font.BOLD, 20));
        print.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        print.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        print.addActionListener(this);
        print.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                print.setBackground(new Color(0, 178, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
              print.setBackground(new Color(255, 0, 0));
            }
            
        });
        add(print);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                new FeesStructure().setVisible(true);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       String btn = e.getActionCommand();
       if (btn.equals("Print")) {
        try {
            table.print();
            this.dispose();
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        
       }
    }
}
