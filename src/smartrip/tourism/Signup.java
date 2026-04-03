
package smartrip.tourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener{
  
    JButton Create,Back;
    JTextField tfname, tfusername, tfPassword, tfAnswer;
    Choice Security;
            
            
            
            
            
    Signup() {
     setBounds(350, 200, 900, 360);
     getContentPane().setBackground(Color.white);
     setLayout(null);
     
     JPanel p1 = new JPanel();
     p1.setBackground(new Color(198, 234, 203));
     p1.setBounds(0, 0, 500, 400);
     
     p1.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 40));// Left aligned with hgap=15, vgap=20
     p1.setLayout(null);
     add(p1);
     
     
         JLabel lblusername = new JLabel("Username");
         lblusername.setBounds(50, 20, 125, 25);
         lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
         p1.add(lblusername);
         
         tfusername = new JTextField();
         tfusername.setBounds(190, 20, 200, 25);
         tfusername.setBorder(BorderFactory.createEmptyBorder());
         p1.add(tfusername);
         
         
         JLabel lblname = new JLabel("Name");
         lblname.setBounds(50, 60, 125, 25);
         lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
         p1.add(lblname);
         
         tfname = new JTextField();
         tfname.setBounds(190, 60, 200, 25);
         tfname.setBorder(BorderFactory.createEmptyBorder());
         p1.add(tfname);
         
         
         JLabel lblPassword = new JLabel("Password");
         lblPassword.setBounds(50, 100, 125, 25);
         lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
         p1.add(lblPassword);
         
         tfPassword = new JTextField();
         tfPassword.setBounds(190, 100, 200, 25);
         tfPassword.setBorder(BorderFactory.createEmptyBorder());
         p1.add(tfPassword);
         
     
         JLabel lblSecurity = new JLabel("Security Question");
         lblSecurity.setBounds(50, 140, 125, 25);
         lblSecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
         p1.add(lblSecurity);
         
         
         
         Security = new Choice();
         Security.add("What is your pet’s name?");
         Security.add("What is your mother’s maiden name?");
         Security.add("What was the name of your first school?");
         Security.add("What is your favorite color?");
         Security.add("What is your birthplace?");
         Security.add("What is your best friend’s name?");
         
         Security.setBounds(190, 140, 200, 25);  // Adjust position & size
         p1.add(Security);

         JLabel lblAnswer = new JLabel("Answer");
         lblAnswer.setBounds(50, 180, 125, 25);
         lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
         p1.add(lblAnswer);
         
         tfAnswer = new JTextField();
         tfAnswer.setBounds(190, 180, 200, 25);
         tfAnswer.setBorder(BorderFactory.createEmptyBorder());
         p1.add(tfAnswer);
         
         
         Create = new JButton("Create");
         Create.setBackground(new Color(34, 139, 34));
         Create.setForeground(Color.white);
         Create.setFont(new Font("Tahoma", Font.BOLD, 14));
         Create.setBounds(80, 250, 100, 30);
         Create.addActionListener(this);
         p1.add(Create);

         
         Back = new JButton("Back");
         Back.setBackground(new Color(34, 139, 34));
         Back.setForeground(Color.white);
         Back.setFont(new Font("Tahoma", Font.BOLD, 14));
         Back.setBounds(250, 250, 100, 30);
         Back.addActionListener(this);
         p1.add(Back);
         
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signicon.png"));
         Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
    
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(580, 50, 250, 250);
         add(image);
         
         
    
     setVisible(true);
}
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == Create ){
           String username =  tfusername.getText();
           String name =  tfname.getText();
           String Password =  tfPassword.getText();
           String Question = Security.getSelectedItem();
           String Answer = tfAnswer.getText();
           
           
           String query = "insert into account value('"+username+"','"+name+"', '"+Password+"', '"+Question+"', '"+Answer+"' )";
           
           try {
           
               conn c = new conn();
               c.s.executeUpdate(query);
               
              JOptionPane.showMessageDialog(null, "Account Created Successfully");
              
              setVisible(false);
              new login();
           
           }catch(Exception e) {
             e.printStackTrace();
           }
         
         }else if (ae.getSource() == Back){
          setVisible(false);
          new login();
         }
    
    }
    
    public static void main(String[] args) {
         new Signup(); 
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
