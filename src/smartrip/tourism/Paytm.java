package smartrip.tourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener {

    JEditorPane pane;

    Paytm() {
        setBounds(500, 200, 800, 600);
        setLayout(null);

        // JEditorPane setup
        pane = new JEditorPane();
        pane.setEditable(false);

        try {
            pane.setPage("https://paytm.com/rent-payment");
        } catch (Exception e) {
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404</html>");
        }

        JScrollPane sp = new JScrollPane(pane);
        sp.setBounds(10, 70, 760, 480);
        add(sp);

        JButton back = new JButton("Back");
        back.setBounds(680, 20, 80, 40);
        back.setBackground(new Color(198, 234, 203));
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Payment();
    }

    public static void main(String[] args) {
        new Paytm();
    }
}
