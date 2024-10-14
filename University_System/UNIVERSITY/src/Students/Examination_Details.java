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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;
import Database.Conn;

public class Examination_Details extends JDialog implements ActionListener{
    private JLabel heading;
    private JTextField search;
    private JButton checkResult, cancel;
    private JTable table;
   

    public Examination_Details() {
        setTitle("Makaut W.B.");
        setSize(1000, 475);
        setLocation(300, 100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setModal(true);
        getContentPane().setBackground(Color.GRAY);
        addComponents();
    }

    private void addComponents() {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("Images/M.png"));
        this.setIconImage(icon.getImage());
        
        heading = new JLabel("Check Result");
        heading.setBounds(50, 15, 400, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("Tahoma", Font.PLAIN, 16));
        search.setBorder(BorderFactory.createEmptyBorder(1,2,1,2));
        add(search);

        checkResult = new JButton("Result");
        checkResult.setBounds(300, 90, 120, 30);
        checkResult.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        checkResult.setBackground(new Color(30, 30, 30));
        checkResult.setForeground(Color.WHITE);
        checkResult.setFont(new Font("Arial", Font.BOLD, 15));
        checkResult.addActionListener(this);
        checkResult.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkResult.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                checkResult.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(255,255,255,180)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                checkResult.setBorder(BorderFactory.createLoweredSoftBevelBorder());
            }
            
        });
        add(checkResult);

        cancel = new JButton("Back");
        cancel.setBounds(440, 90, 120, 30);
        cancel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        cancel.setBackground(new Color(220, 0, 0));
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Arial", Font.BOLD, 15));
        cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cancel.addActionListener(this);
        cancel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                cancel.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(255,255,255,180)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
            }
            
        });
        add(cancel);


        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,130,1000,300);
        add(jsp);

        JTableHeader tHeader = table.getTableHeader();
        tHeader.setBackground(new Color(66, 165, 245));
        tHeader.setForeground(Color.WHITE);
        tHeader.setFont(new Font("Tahoma", Font.BOLD, 12));
        ((DefaultTableCellRenderer)tHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT name,roll,course,branch FROM student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
           e.printStackTrace();
        }
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
               int row = table.getSelectedRow();
              search.setText(table.getModel().getValueAt(row, 1).toString()); 
            }
            
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Examination_Details().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String searchtf = search.getText();
        

      if (e.getSource() == checkResult) {
        if (searchtf.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Select the Roll");
        }
        else{
            this.dispose();
            new Marks(search.getText());
        }
       
      
      }else{
        this.dispose();
      }
    }
}
