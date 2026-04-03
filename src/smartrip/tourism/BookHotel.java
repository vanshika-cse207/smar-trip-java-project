
package smartrip.tourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {

    
   
    String username;
    Choice chotel , cac, cfood;
    JTextField tfpersons , tfdays;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton  checkprice, bookhotel, back;
    
    
    BookHotel(String username) {
        this.username = username;

        setBounds(350, 200, 1100, 600);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Book Hotel");
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

        
        JLabel lblpackage= new JLabel("Select Hotel");
        lblpackage.setBounds(40, 110, 150, 20);
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpackage);
        
        chotel = new Choice();
        chotel.setBounds(250,110,200,20);
        add(chotel);
        
        try {
           conn c = new conn();
           ResultSet rs = c.s.executeQuery("select * from hotel");
          while(rs.next()) {
          
            chotel.add(rs.getString("name"));
          }
        
        
        } catch (Exception e) {
          e.printStackTrace();
        }
        
        
        
        
        
        JLabel lblperson= new JLabel("Total Person");
        lblperson.setBounds(40, 150, 150, 25);
        lblperson.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblperson);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);
        
        
        JLabel lbldays= new JLabel("No. of Days");
        lbldays.setBounds(40, 190, 150, 25);
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldays);
        
        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);
        
        
        JLabel lblac= new JLabel("AC / Non-AC");
        lblac.setBounds(40, 230, 150, 25);
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230,200,20);
        add(cac);
        
        
        JLabel lblfood= new JLabel("Food Include");
        lblfood.setBounds(40, 270, 150, 25);
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfood);
        
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270,200,20);
        add(cfood);
        
        
        JLabel lblid= new JLabel("Id");
        lblid.setBounds(40, 310, 150, 20);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);
      
        labelid= new JLabel();
        labelid.setBounds(250, 310, 200, 25);
        add(labelid);

        JLabel lblnumber= new JLabel("Number");
        lblnumber.setBounds(40, 350, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnumber);
        
        labelnumber= new JLabel();
        labelnumber.setBounds(250, 350, 150, 25);
        add(labelnumber);

        
   
                
        JLabel lblphone= new JLabel("Phone");
        lblphone.setBounds(40, 390, 150, 20);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);
      
        labelphone= new JLabel();
        labelphone.setBounds(250, 390, 200, 25);
        add(labelphone);

        JLabel lbltotal= new JLabel("Total Price");
        lbltotal.setBounds(40, 430, 150, 25);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);
        
        labelprice= new JLabel();
        labelprice.setBounds(250, 430, 150, 25);
        add(labelprice);

         try {
    conn c = new conn();

    // Query from customer table, not hotel
    String query = "select * from customer where username = '"+username+"'";
    ResultSet rs = c.s.executeQuery(query);

    if (rs.next()) {
        labelusername.setText(rs.getString("username"));  // username
        labelid.setText(rs.getString("id"));              // id
        labelnumber.setText(rs.getString("number"));      // number
        labelphone.setText(rs.getString("phone"));        // phone
    }

} catch (Exception e) {
    e.printStackTrace();
}


        
        
       
        checkprice = new JButton("Check Price");
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.setBackground(new Color(198, 234, 203));
        checkprice.setForeground(Color.black);
        checkprice.addActionListener(this);
        add(checkprice);
        
        
       
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(200, 490, 120, 25);
        bookhotel.setBackground(new Color(198, 234, 203));
        bookhotel.setForeground(Color.black);
        bookhotel.addActionListener(this);
        add(bookhotel);
        
        
        
        back = new JButton("Back");
        back.setBounds(340, 490, 120, 25);
        back.setBackground(new Color(198, 234, 203));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hotel7.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500, 50, 600, 300);
        add(l12);

        
        
        

        

        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
       
       if (ae.getSource() == checkprice) {
           
          try { 
           conn c = new conn();
           ResultSet rs = c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"'");
            while(rs.next()){
             int cost = Integer.parseInt(rs.getString("costperperson"));
             int food = Integer.parseInt(rs.getString("foodinclude"));
             int ac  = Integer.parseInt(rs.getString("acroom"));
            
             
            int persons = Integer.parseInt(tfpersons.getText()); 
            int days = Integer.parseInt(tfdays.getText()); 
             
             
             String acselected = cac.getSelectedItem();
             String foodselected = cfood.getSelectedItem();
           
             if (persons * days > 0) {
             
                 int total = 0;
                 total += acselected.equals("AC") ? ac : 0;
                 total += foodselected.equals("Yes") ? food : 0;
                 total += cost;
                 total = total * persons * days;
                 
                 labelprice.setText("Rs" + total);
                 
             
             }else {
                  JOptionPane.showMessageDialog(null, "Please enter a valid number  " );
           
             }
             
            
             
            }
           
           } catch (Exception e) {
              e.printStackTrace();
           }
               
           }else if (ae.getSource() == bookhotel) {
       
           
           try {
           
            conn c = new conn();
             c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"',  '"+chotel.getSelectedItem()+"' , '"+tfpersons.getText()+"','"+tfdays.getText()+"' ,'"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+labelid.getText()+"' , '"+labelnumber.getText()+"' , '"+labelphone.getText()+"'  , '"+labelprice.getText()+"' )");
           
           JOptionPane.showMessageDialog(null, "Hotel booked successfully  " );
           
           
           } catch (Exception e) {
              e.printStackTrace();
           }
           
           
           
           
           
           
           
           
       }else  {
         
           setVisible(false);
       
       }
        
        
        
        
    }
   
    public static void main(String[] args) {
     
         new BookHotel("aliya");
    
    }
    
  }
