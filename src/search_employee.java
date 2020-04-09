import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class search_employee  implements ActionListener {

    JFrame frame;
    JLabel l1;
    JTextField txt1;

    JButton bt1,bt2;
    search_employee(){
        frame = new JFrame();
        frame.setLayout(null);
        JLabel imglabel = new JLabel();
        imglabel.setBounds(0,0,500,270);
        imglabel.setLayout(null);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/view.jpg"));
        imglabel.setIcon(icon);



        l1 = new JLabel("Employee Id");
        l1.setBounds(40,40,180,30);
        l1.setFont(new Font("serif",Font.BOLD,25));
        l1.setForeground(Color.WHITE);
        imglabel.add(l1);

        txt1 = new JTextField();
        txt1.setBounds(230,40,180,30);
        imglabel.add(txt1);

        bt1 = new JButton("Search");
        bt1.setBounds(230,120,90,30);
        imglabel.add(bt1);

        bt2 = new JButton("Cancel");
        bt2.setBounds(340,120,90,30);
        imglabel.add(bt2);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        frame.add(imglabel);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setSize(500,270);
        frame.setLocation(450,250);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(txt1.getText());
        if (e.getSource() == bt1){
            frame.setVisible(false);
            System.out.println("bt1");
            new update_employee(txt1.getText());
        }
        if(e.getSource()==bt2){
            frame.setVisible(false);
            System.out.println("bt2");
            new FunctionalityPage();
        }
    }

}
