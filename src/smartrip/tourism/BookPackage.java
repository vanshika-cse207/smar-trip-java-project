
package smartrip.tourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {

    
   
    String username;
    Choice cpackage;
    JTextField tfpersons;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton  checkprice, bookpackage, back;
    
    
    BookPackage(String username) {
        this.username = username;

        setBounds(350, 200, 1100, 500);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Book Package");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername= new JLabel("Username");
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblusername);

        labelusername= new JLabel();
        labelusername.setBounds(250, 70, 100, 20);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelusername);

        
        JLabel lblpackage= new JLabel("Select Package");
        lblpackage.setBounds(40, 110, 150, 20);
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpackage);
        
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("bronze Package");
        
        cpackage.setBounds(250,110,200,20);
        add(cpackage);
        
        JLabel lblperson= new JLabel("Total Person");
        lblperson.setBounds(40, 150, 150, 25);
        lblperson.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblperson);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);
        
        JLabel lblid= new JLabel("Id");
        lblid.setBounds(40, 190, 150, 20);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);
      
        labelid= new JLabel();
        labelid.setBounds(250, 190, 200, 25);
        add(labelid);

        JLabel lblnumber= new JLabel("Number");
        lblnumber.setBounds(40, 230, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnumber);
        
        labelnumber= new JLabel();
        labelnumber.setBounds(250, 230, 150, 25);
        add(labelnumber);

        
   
                
        JLabel lblphone= new JLabel("Phone");
        lblphone.setBounds(40, 270, 150, 20);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);
      
        labelphone= new JLabel();
        labelphone.setBounds(250, 270, 200, 25);
        add(labelphone);

        JLabel lbltotal= new JLabel("Total Price");
        lbltotal.setBounds(40, 310, 150, 25);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);
        
        labelprice= new JLabel();
        labelprice.setBounds(250, 310, 150, 25);
        add(labelprice);

        
        
         try {
           
               conn c = new conn();
               String query = "select * from customer where username = '"+username+"'";
               ResultSet rs = c.s.executeQuery(query);
               while (rs.next()) {

                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                
                labelphone.setText(rs.getString("phone"));
                
               }
           
           } catch (Exception e) {
                 e.printStackTrace();
             }
       
        checkprice = new JButton("Check Price");
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.setBackground(new Color(198, 234, 203));
        checkprice.setForeground(Color.black);
        checkprice.addActionListener(this);
        add(checkprice);
        
        
       
        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.setBackground(new Color(198, 234, 203));
        bookpackage.setForeground(Color.black);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        
        
        back = new JButton("Back");
        back.setBounds(340, 380, 120, 25);
        back.setBackground(new Color(198, 234, 203));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(550, 50, 500, 300);
        add(l12);

        
        
        

        

        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
       
       if (ae.getSource() == checkprice) {
         
           String pack = cpackage.getSelectedItem();
           int cost = 0;
           if(pack.equals("Gold Package")) {
              cost += 12000;
           }else if (pack.equals("Silver Package")) {
              cost +=25000;
           }else {
               
               cost += 32000;
           }
       
            int persons = Integer.parseInt(tfpersons.getText());  
             cost *= persons;
             labelprice.setText("Rs" +cost);
           
           }else if (ae.getSource() == bookpackage) {
       
           
           try {
           
            conn c = new conn();
           c.s.executeUpdate("insert into bookpackage value('"+labelusername.getText() +"',  '"+cpackage.getSelectedItem()+"' , '"+tfpersons.getText()+"', '"+labelid.getText()+"' , '"+labelnumber.getText()+"' , '"+labelphone.getText()+"'  , '"+labelprice.getText()+"' )");
           
           JOptionPane.showMessageDialog(null, "Package  booked successfully  " );
           
           
           } catch (Exception e) {
              e.printStackTrace();
           }
           
           
           
           
           
           
           
           
       }else  {
         
           setVisible(false);
       
       }
        
        
        
        
    }
   
    public static void main(String[] args) {
     
         new BookPackage("aliya");
    
    }
    
  }
