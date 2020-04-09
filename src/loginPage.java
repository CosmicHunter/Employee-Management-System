import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class loginPage implements ActionListener {

     JFrame frame;
     JLabel l1,l2;
     JTextField txt1;
     JPasswordField pass;
     JButton bt1,bt2;

     loginPage(){
         frame = new JFrame("Login");
         frame.setBackground(Color.WHITE);
         frame.setLayout(null);

         l1 = new JLabel("Username");
         l1.setBounds(40,20,100,30);
         frame.add(l1);

         l2 = new JLabel("Password");
         l2.setBounds(40,70,100,30);
         frame.add(l2);

         txt1 = new JTextField();
         txt1.setBounds(150,20,150,30);
         frame.add(txt1);

         pass = new JPasswordField();
         pass.setBounds(150,70,150,30);
         frame.add(pass);


         // Adding Image
         ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
         // Resiziing the imageicon in the image object
         // In getScaledInstance we pass height and width of image.
         Image img = icon1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
         ImageIcon icon2 = new ImageIcon(img);
         JLabel label_for_img = new JLabel(icon2);
         label_for_img.setBounds(350,20,150,150);
         frame.add(label_for_img);

         // Adding Buttons
         bt1 = new JButton("Login");
         bt1.setBounds(40,140,120,30);
         bt1.setFont(new Font("serif",Font.BOLD,15));
         bt1.addActionListener(this);
         bt1.setBackground(Color.BLACK);
         bt1.setForeground(Color.WHITE);
         frame.add(bt1);

         bt2 = new JButton("Cancel");
         bt2.setBounds(180,140,120,30);
         bt2.setFont(new Font("serif",Font.BOLD,15));
         bt2.addActionListener(this);
         bt2.setBackground(Color.BLACK);
         bt2.setForeground(Color.WHITE);
         frame.add(bt2);

         frame.getContentPane().setBackground(Color.WHITE);
         frame.setVisible(true);
         frame.setSize(600,300);
         frame.setLocation(400,300);
         frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);


     }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt2) {
          // new LandingPage();
            frame.setVisible(false);
            frame.dispose();

        }
        if (e.getSource() == bt1){
            try {
                conn conn_obj = new conn();
                String uname = txt1.getText();
                String pwd = pass.getText();
                String query = "select * from login where username ='" + uname + "' and password='" + pwd + "'";
                ResultSet rs = conn_obj.stmt.executeQuery(query);
                if (rs.next()) {
                    // new frame
                    new FunctionalityPage();
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Password/Username");
                    frame.setVisible(false);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }

     }  // end of action performed

}
