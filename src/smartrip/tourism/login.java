

package smartrip.tourism;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;


 public class login extends JFrame  implements ActionListener {
    
    JButton Login , Signup , Password;
    JTextField tfpassword, tfusername;
    
    login() {
    
    setSize(900, 400);
    setLocation(350, 200);
    setLayout(null);
    
    getContentPane().setBackground(Color.white);
    
    JPanel p1 = new JPanel();
    p1.setBackground(new Color(198, 234, 203)); // Light Mint Green
    p1.setBounds(0, 0, 400, 400);
    
    add(p1);
    
  
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/loginpage.png"));
    Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
    
     ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(100, 120, 200, 200);
         p1.add(image);
         
         
         
         
         JPanel p2 = new JPanel();
         p2.setLayout(null);
         p2.setBounds(400, 30, 450, 300);
         add(p2);
         
         
         JLabel lblusername = new JLabel("Username");
         lblusername.setBounds(60, 20, 100, 25);
         lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
         p2.add(lblusername);
         
         tfusername = new JTextField();
         tfusername.setBounds(60, 60, 300, 30);
         tfusername.setBorder(BorderFactory.createEmptyBorder());
         p2.add(tfusername);
         
         
         
         
         JLabel lblpassword = new JLabel("password");
         lblpassword.setBounds(60, 110, 100, 25);
         lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
         p2.add(lblpassword);
         
         tfpassword = new JTextField();
         tfpassword.setBounds(60, 150, 300, 30);
         tfpassword.setBorder(BorderFactory.createEmptyBorder());
         p2.add(tfpassword);
         
         
         Login = new JButton("Login");
         Login.setBounds(60, 200, 130, 30);
         Login.setBackground(new Color(34, 139, 34));
         Login.setForeground(Color.white);
         Login.setBorder(new LineBorder(new Color(198, 234, 203)));
         Login.addActionListener(this);
         p2.add(Login);
         
         
         Signup = new JButton("Signup");
         Signup.setBounds(230, 200, 130, 30);
         Signup.setBackground(new Color(34, 139, 34));
         Signup.setForeground(Color.white);
         Signup.setBorder(new LineBorder(new Color(198, 234, 203)));
         Signup.addActionListener(this);
         p2.add(Signup);
         
         
         
          Password = new JButton("Forget Password");
          Password.setBounds(130, 250, 130, 30);
          Password.setBackground(new Color(34, 139, 34));
          Password.setForeground(Color.white);
          Password.setBorder(new LineBorder(new Color(198, 234, 203))); 
          Password.addActionListener(this);
         p2.add( Password);
         
         
         JLabel text = new JLabel("Trouble in login...");
         text.setBounds(300, 250, 150, 20);
         text.setForeground(Color.red);
         p2.add(text);
         
         
         
         setVisible(true);
         
         
    }
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == Login) {
           try {
           
           String username = tfusername.getText();
           String pass = tfpassword.getText();
           
           
            String query = "select * from account where username = '"+username+"'AND Password = '"+pass+"'";
                conn c = new conn();
                
                ResultSet   rs = c.s.executeQuery(query);
                if(rs.next()){
                 
                  setVisible(false);
                  new loading(username);
                 
                }else {
                
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
                
                }
           
           
           
           
           } catch (Exception e){
             
               e.printStackTrace();
           
           }
        
        }else if (ae.getSource() == Signup) {
           setVisible(false);
           new Signup();
        
         } else {
            
            setVisible(false);
            new forgetpassword();
         }
    
     }
    
         public static void main(String[] args) {
         new login(); 
    } 
    
    
    
    
 }

