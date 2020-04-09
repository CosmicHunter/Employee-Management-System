import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class remove_employee implements ActionListener {
    JFrame frame;
    JTextField txt1;
    JLabel eidlabel , namelabel, phonelabel,idlabel;
    JLabel l1,l2,l3;
    JButton searchbt,rmbt,cancelbt,backbt;

    remove_employee(){
        frame=new JFrame("Remove Employee");
        frame.setBackground(Color.green);
        frame.setLayout(null);

        JLabel imglabel=new JLabel();
        imglabel.setBounds(0,0,500,500);
        imglabel.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/remove.jpg"));
        imglabel.setIcon(img);
        frame.add(imglabel);


        l1=new JLabel("Employee Id");
        l1.setBounds(50,50,250,30);
        l1.setForeground(Color.white);
        Font f2 = new Font("serif",Font.BOLD,25);
        l1.setFont(f2);
        imglabel.add(l1);

        txt1=new JTextField();
        txt1.setBounds(250,50,150,30);
        imglabel.add(txt1);


        searchbt=new JButton("Search");
        searchbt.setBounds(200,100,100,30);
        searchbt.addActionListener(this);
        imglabel.add(searchbt);

        backbt=new JButton("Back");
        backbt.setBounds(360,100,100,30);
        backbt.addActionListener(this);
        imglabel.add(backbt);


        namelabel=new JLabel("Name:");
        namelabel.setBounds(50,150,250,30);
        namelabel.setForeground(Color.white);
        Font f3 = new Font("serif",Font.BOLD,20);
        namelabel.setFont(f3);
        imglabel.add(namelabel);

        l1=new JLabel();
        l1.setBounds(200,150,350,30);
        l1.setForeground(Color.white);
        Font F6=new Font("serif",Font.BOLD,20);
        l1.setFont(F6);
        imglabel.add(l1);

        phonelabel=new JLabel("Mobile No:");
        phonelabel.setBounds(50,200,250,30);
        phonelabel.setForeground(Color.white);
        Font f4 = new Font("serif",Font.BOLD,20);
        phonelabel.setFont(f4);
        imglabel.add(phonelabel);


        l2=new JLabel();
        l2.setBounds(200,200,350,30);
        l2.setForeground(Color.white);
        Font F7=new Font("serif",Font.BOLD,20);
        l2.setFont(F7);
        imglabel.add(l2);



        idlabel=new JLabel("Email Id:");
        idlabel.setBounds(50,250,250,30);
        idlabel.setForeground(Color.white);
        Font F5=new Font("serif",Font.BOLD,20);
        idlabel.setFont(F5);
        imglabel.add(idlabel);

        l3=new JLabel();
        l3.setBounds(200,250,350,30);
        l3.setForeground(Color.white);
        Font f8=new Font("serif",Font.BOLD,20);
        l3.setFont(f8);
        imglabel.add(l3);

        rmbt=new JButton("Remove");
        rmbt.setBounds(120,300,100,30);
        rmbt.addActionListener(this);
        imglabel.add(rmbt);


        cancelbt=new JButton("Cancel");
        cancelbt.setBounds(300,300,100,30);
        cancelbt.addActionListener(this);
        imglabel.add(cancelbt);

        namelabel.setVisible(false);
        idlabel.setVisible(false);
        phonelabel.setVisible(false);
        rmbt.setVisible(false);
        cancelbt.setVisible(false);

        frame.setSize(500,500);
        frame.setLocation(500,250);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
             if(e.getSource() == searchbt){
                 try{
                      conn conn_obj = new conn();
                      String str = "select name,phone,email from employee where emp_id = '"+txt1.getText()+"' ";
                      ResultSet rs = conn_obj.stmt.executeQuery(str);

                     Boolean flag = false;
                     if(rs.next()){
                         String name = rs.getString(1);
                         String phone = rs.getString(2);
                         String id=rs.getString(3);

                         namelabel.setVisible(true);
                         idlabel.setVisible(true);
                         phonelabel.setVisible(true);
                         rmbt.setVisible(true);
                         cancelbt.setVisible(true);
                         flag = true;
                         l1.setText(name);
                         l2.setText(phone);
                         l3.setText(id);
                     }
                     if(!flag)
                         JOptionPane.showMessageDialog(null,"Employee Does not exist!");
                 }catch (Exception ex){
                       ex.printStackTrace();
                 }
             }

        if(e.getSource()==rmbt){
            try{
                conn conn_obj = new conn();
                String str = "delete from employee where emp_id = '"+txt1.getText()+"'";
                conn_obj.stmt.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Deleted Successfully");
                l1.setVisible(false);
                l2.setVisible(false);
                l3.setVisible(false);
                namelabel.setVisible(false);
                idlabel.setVisible(false);
                phonelabel.setVisible(false);
                rmbt.setVisible(false);
                cancelbt.setVisible(false);

            }catch(Exception ex){
                 JOptionPane.showMessageDialog(null,"Exception occured while delting record "+ex);
            }
    }

        if (e.getSource() == backbt){
            frame.setVisible(false);
            new FunctionalityPage();
        }
        if(e.getSource() == cancelbt){
            frame.setVisible(false);
            new FunctionalityPage();
        }

    }
}
