import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class view_employee implements ActionListener {

     JFrame frame;
     JLabel imglabel;
     JLabel eidlabel;
     JTextField eidtxt;

     JButton bt1,bt2;

     view_employee(){
         frame = new JFrame("View Details");
         frame.setBackground(Color.GREEN);
         frame.setLayout(null);

         imglabel  = new JLabel();
         imglabel.setBounds(0,0,500,270);
         imglabel.setLayout(null);
         ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/view.jpg"));
         imglabel.setIcon(icon);

         eidlabel=new JLabel("Employee Id");
         eidlabel.setVisible(true);
         eidlabel.setBounds(40,60,250,30);
         eidlabel.setForeground(Color.white);
         Font F1 = new Font("serif",Font.BOLD,30);
         eidlabel.setFont(F1);
         imglabel.add(eidlabel);
         frame.add(imglabel);


         eidtxt=new JTextField();
         eidtxt.setBounds(240,60,220,30);
         imglabel.add(eidtxt);

         bt1=new JButton("Search");
         bt1.setBounds(240,150,100,30);
         bt1.addActionListener(this);
         imglabel.add(bt1);

         bt2=new JButton("Cancel");
         bt2.setBounds(360,150,100,30);
         bt2.addActionListener(this);
         imglabel.add(bt2);

         frame.setSize(500,270);
         frame.setLocation(450,250);
         frame.setVisible(true);
         frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt2){
            frame.setVisible(false);
            new FunctionalityPage();
        }
        if(e.getSource()==bt1){
            frame.setVisible(false);
            new show_employee_details(eidtxt.getText());
        }

    }
}
