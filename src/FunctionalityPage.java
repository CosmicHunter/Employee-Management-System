import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunctionalityPage implements ActionListener {
    JFrame frame;
    JLabel l1,l2;

    JButton addbt,rmbt,viewbt,updatebt;

    FunctionalityPage(){
        frame = new JFrame("Employee Detail");
        frame.setBackground(Color.white);
        frame.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
        l1.setIcon(icon1);
        frame.add(l1);

        l2 = new JLabel("Employee Details");
        l2.setBounds(430,20,200,40);
        l2.setFont(new Font("serif",Font.BOLD,25));
        l2.setForeground(Color.BLACK);
        l1.add(l2);

        addbt = new JButton("ADD");
        addbt.setBounds(410,80,120,40);
        addbt.addActionListener(this);
        addbt.setFont(new Font("serif",Font.BOLD,15));
        l1.add(addbt);

        viewbt = new JButton("VIEW");
        viewbt.setBounds(410,140,120,40);
        viewbt.addActionListener(this);
        viewbt.setFont(new Font("serif",Font.BOLD,15));
        l1.add(viewbt);
        
        rmbt = new JButton("REMOVE");
        rmbt.setBounds(540,80,120,40);
        rmbt.addActionListener(this);
        rmbt.setFont(new Font("serif",Font.BOLD,15));
        l1.add(rmbt);

        updatebt = new JButton("UPDATE");
        updatebt.setBounds(540,140,120,40);
        updatebt.addActionListener(this);
        updatebt.setFont(new Font("serif",Font.BOLD,15));
        l1.add(updatebt);

        frame.setVisible(true);
        frame.setSize(700,500);
        frame.setLocation(450,200);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addbt){
               new add_employee();
               frame.setVisible(false);
        }
        if(e.getSource() == rmbt){
            new remove_employee();
            frame.setVisible(false);
        }
        if(e.getSource() == viewbt){
            new view_employee();
            frame.setVisible(false);
        }
        if(e.getSource() == updatebt){
            new search_employee();
            frame.setVisible(false);
        }
    }


}
