package smartrip.tourism;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

    CheckPackage() {

        setBounds(450, 200, 900, 600);

        String[] package1 = new String[]{
                "package1.jpg", "GOLD PACKAGE", "6 days and 7 Nights",
                "Airport Assistance at Airport", "One Day City Tour",
                "Welcome drinks on Arrival", "Daily Buffet",
                "English Speaking Guide", "BOOK NOW",
                "Summer Special", "Rs 12000 only",
                "package1.jpg"
        };

        String[] package2 = new String[]{
                "package2.jpg", "SILVER PACKAGE", "4 days and 3 Nights",
                "Toll Free", "Entrance Free Tickets",
                "Meet and Greet at Airport", "Welcome drinks on Arrival",
                "Cruise with Dinner", "BOOK NOW",
                "Winter Special", "Rs 25000 only",
                "package2.jpg"
        };

        String[] package3 = new String[]{
                "package3.jpg", "BRONZE PACKAGE", "6 days and 5 Nights",
                "Return Airfare", "Free Clubbing",
                "Horse Riding & Games", "Daily Buffet",
                "Stay in 5 Star Hotel", "BOOK NOW",
                "Winter Special", "Rs 32000 only",
                "package3.jpg"
        };

        JTabbedPane tab = new JTabbedPane();
        tab.addTab("Package 1", null, createPackage(package1));
        tab.addTab("Package 2", null, createPackage(package2));
        tab.addTab("Package 3", null, createPackage(package3));

        add(tab);
        setVisible(true);
    }


    public JPanel createPackage(String[] pack) {

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);

        JLabel l1 = new JLabel(pack[1]);
        l1.setBounds(50, 5, 300, 30);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(l1);

        JLabel l2 = new JLabel(pack[2]);
        l2.setBounds(30, 60, 300, 30);
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l2);

        JLabel l3 = new JLabel(pack[3]);
        l3.setBounds(30, 110, 300, 30);
        l3.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l3);

        JLabel l4 = new JLabel(pack[4]);
        l4.setBounds(30, 160, 300, 30);
        l4.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l4);

        JLabel l5 = new JLabel(pack[5]);
        l5.setBounds(30, 210, 300, 30);
        l5.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l5);

        JLabel l6 = new JLabel(pack[6]);
        l6.setBounds(30, 260, 300, 30);
        l6.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l6);

        JLabel l7 = new JLabel(pack[7]);
        l7.setBounds(30, 310, 400, 30);
        l7.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l7);

        JLabel l8 = new JLabel(pack[8]);
        l8.setBounds(60, 380, 300, 30);
        l8.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(l8);

        JLabel l9 = new JLabel(pack[9]);
        l9.setBounds(80, 430, 300, 30);
        l9.setForeground(Color.ORANGE);
        l9.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(l9);

        JLabel l10 = new JLabel(pack[10]);
        l10.setBounds(500, 430, 300, 30);
        l10.setForeground(Color.MAGENTA);
        l10.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(l10);

        // ✅ FIXED IMAGE LOADING
        ImageIcon rawIcon = new ImageIcon(ClassLoader.getSystemResource("icon/" + pack[11]));
        Image scaledImg = rawIcon.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));

        imageLabel.setBounds(350, 20, 500, 300);
        p1.add(imageLabel);

        return p1;
    }

    public static void main(String[] args) {
        new CheckPackage();
    }
}
