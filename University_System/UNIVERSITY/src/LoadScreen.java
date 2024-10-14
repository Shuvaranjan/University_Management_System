import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class LoadScreen extends JFrame {
    JLabel label1;
    JProgressBar jb;
    int i = 0, num = 0;

    public LoadScreen() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setComponents();
        setSize(400, 200);
        setUndecorated(true);
    }

    public void iterate() {
        while (i <= 2000) {
            jb.setValue(i);
            i = i + 4;
            try {
                Thread.sleep(8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void setComponents() {

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("Images/computer.png"));
        Image img2 = img1.getImage().getScaledInstance(1600, 1000, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel backgroundImg = new JLabel(img3);
        backgroundImg.setBounds(0, 0, 1600, 1000);
        backgroundImg.setLayout(null);
        add(backgroundImg);

        label1 = new JLabel("Makaut");
        label1.setBounds(430, 185, 1000, 500);
        label1.setForeground(new Color(255, 255, 255, 185));
        label1.setFont(new Font("Tahoma", Font.BOLD, 200));
        backgroundImg.add(label1);

        jb = new JProgressBar(0, 2000);
        jb.setBounds(200, 650, 1200, 18);
        jb.setValue(0);
        jb.setForeground(new Color(255, 255, 255));
        jb.setBackground(new Color(0, 0, 0));
        jb.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        backgroundImg.add(jb);
    }

    public static void main(String[] args) {
        LoadScreen m = new LoadScreen();
        m.setVisible(true);
        m.iterate();
        try {
            Thread.sleep(200);
            m.dispose();
            new Dasboard().setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
