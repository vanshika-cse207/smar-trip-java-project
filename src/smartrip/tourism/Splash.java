
package smartrip.tourism;


import javax.swing.*;
import java.awt.*;

public  class Splash extends JFrame implements Runnable{
    
    Thread thread ;
    
     Splash() {
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/home.png"));
         
         Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i1);
         add(image);
         
        JLabel text = new JLabel ("Smartrip Jharkhand Eco Tours");
        text.setBounds(200, 265, 800, 70);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway", Font.PLAIN, 55));
        image.add(text);
        
        setVisible(true);
         thread = new Thread(this);
        thread.start();
     }
       
      public void run() {
          
          try{
            Thread.sleep(7000);
            
              this.setVisible(false);
            this.dispose();  // better to dispose resources
 
        // Open the Login window
        login login = new login();
        login.setVisible(true);
            
           // new Login();
           setVisible(false);
          
          } catch (Exception e) {}
      
      }
    public static void main(String[] args) {
      Splash frame = new Splash();
       int x = 1;
       for(int i = 1; i <=500; x+=7, i+=6){
          frame.setLocation(750 - (x + i)/2, 400 - (i/2));
          frame.setSize(x + i , i);
          try {
              Thread.sleep(10);
              
          } catch (Exception e) {} 
              
              }
       
    }       
}
