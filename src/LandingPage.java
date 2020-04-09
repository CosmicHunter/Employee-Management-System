import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;

public class LandingPage implements ActionListener {
    JFrame frame;
    JLabel label_for_img,title_label;
    JButton bt1;

    LandingPage(){
        frame = new JFrame("Employee Management System");
        frame.setBackground(Color.CYAN);
        frame.setLayout(null);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        // Resiziing the imageicon in the image object
        // In getScaledInstance we pass height and width of image.
        Image img = icon1.getImage().getScaledInstance(1200 , 700,Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(img);
        label_for_img = new JLabel(icon2);

        label_for_img.setBounds(0,150,1360,530);
        frame.add(label_for_img);

         bt1 = new JButton("Continue");
         bt1.setBackground(Color.BLACK);
         bt1.setForeground(Color.WHITE);

         bt1.setBounds(550,600,220,45);
         bt1.setFont(new Font("Arial", Font.PLAIN, 37));
         // Add Action Listener
         bt1.addActionListener(this);

        JLabel label = new JLabel();
        label.setBounds(0,0,1360,750);
        label.setLayout(null);

        title_label = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        title_label.setBounds(80,20,1500,100);
        title_label.setFont(new Font("serif",Font.PLAIN,70));
        title_label.setForeground(Color.BLUE);

        label.add(title_label);
        label.add(bt1);

        frame.add(label);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setSize(1360,750); // To set at which location on our desktop the frame will pop up
        frame.setLocation(200,100);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        // Adding Effects (To blink the title of the title label)
        while(true){
            title_label.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (Exception e){

            }
            title_label.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch (Exception e){

            }
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
           if(e.getSource() == bt1){
               frame.setVisible(false);
               frame.dispose();
               new loginPage();

           }
    }


    public static void main(String [] args){
        // Create Landing Page Object here
        new LandingPage();
    }
}
