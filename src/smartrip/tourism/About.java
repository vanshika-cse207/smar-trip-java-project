package smartrip.tourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {
   
    About() {
        setBounds(600, 200, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel l1 = new JLabel("About");
        l1.setBounds(200, 10, 100, 40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);
        
        String s = "About Projects\n\n" +
            "SmarTrip Jharkhand Eco Tours is a dedicated travel " +
            "initiative focused on showcasing the natural beauty and cultural richness of Jharkhand " +
            "through sustainable and eco-friendly tourism experiences.\n\n" +
            "Our mission is to connect travelers with the untouched landscapes, vibrant tribal heritage, and serene eco-destinations of this unique Indian state,\n" +
            "all while promoting responsible travel practices that protect the environment and empower local communities.\n\n" +
            "From lush forests and waterfalls to ancient rock art and wildlife sanctuaries,\n" +
            "SmarTrip offers carefully curated tours that encourage deeper appreciation for Jharkhand’s ecological and cultural treasures.\n\n" +
            "We believe in travel that respects nature, supports conservation, and fosters meaningful interactions between visitors and indigenous people.\n\n" +
                
            "Whether you’re an adventure seeker, nature lover, or cultural enthusiast,\n" +
                
            "SmarTrip Jharkhand Eco Tours provides a thoughtful and immersive way to explore the heart of Jharkhand — sustainably, respectfully, and memorably.";
        
        TextArea area = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        add(area);
        
        JButton back = new JButton("Back");
        back.setBounds(200, 420, 100, 25);
        back.setBackground(new Color(198, 234, 203));
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    } 
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new About();
    }
}
