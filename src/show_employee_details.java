import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class show_employee_details implements ActionListener {

    JFrame frame;
    JLabel titlelabel,namelabel,agelabel,idlabel,joblabel,eidlabel,fnamelabel,phonelabel,edulabel,adresslabel;
    String eid,name,fname,address,phone,id,edu,job,age,dob,aadhar;
    JButton bt1,bt2;
    ImageIcon icon;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;

    show_employee_details(String emp_id){
        try{
            conn conn_obj = new conn();
            String query = "select * from employee where emp_id = '"+emp_id+"'";
            ResultSet rs = conn_obj.stmt.executeQuery(query);

            while (rs.next()){
                name = rs.getString("name");
                fname = rs.getString("fname");
                age = rs.getString("age");
                dob = rs.getString("dob");
                address = rs.getString("address");
                phone = rs.getString("phone");
                id = rs.getString("email");
                edu = rs.getString("education");
                job = rs.getString("post");
                aadhar = rs.getString("aadhar");
                eid = rs.getString("emp_id");
            }
        }
        catch (Exception e){
           e.printStackTrace();
        }

        frame = new JFrame("Employee Details");
        frame.setVisible(true);
        frame.setSize(595,642);
        frame.setLocation(450,200);
        frame.setBackground(Color.white);
        frame.setLayout(null);


        JLabel imglabel =new JLabel();
        imglabel.setBounds(0,0,595,642);
        imglabel.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/print.jpg"));
        imglabel.setIcon(img);
        frame.add(imglabel);
        
        titlelabel = new JLabel("Employee Details");
        titlelabel.setBounds(50,10,250,30);
        titlelabel.setFont(new Font("serif",Font.BOLD,25));
        imglabel.add(titlelabel);
       

        eidlabel = new JLabel("Employee Id:");
        eidlabel.setBounds(50,70,120,30);
        eidlabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(eidlabel);

        l1 = new JLabel(eid);
        l1.setBounds(200,70,200,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(l1);

        namelabel = new JLabel("Name:");
        namelabel.setBounds(50,120,100,30);
        namelabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(namelabel);

        l2 = new JLabel(name);
        l2.setBounds(200,120,300,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(l2);


        fnamelabel = new JLabel("Father's Name:");
        fnamelabel.setBounds(50,170,200,30);
        fnamelabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(fnamelabel);

        l3 = new JLabel(fname);
        l3.setBounds(200,170,300,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(l3);

        adresslabel= new JLabel("Address:");
        adresslabel.setBounds(50,220,100,30);
        adresslabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(adresslabel);

        l4= new JLabel(address);
        l4.setBounds(200,220,300,30);
        l4.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(l4);


        phonelabel= new JLabel("Mobile No:");
        phonelabel.setBounds(50,270,100,30);
        phonelabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(phonelabel);

        l5= new JLabel(phone);
        l5.setBounds(200,270,300,30);
        l5.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(l5);


        idlabel= new JLabel("Email Id:");
        idlabel.setBounds(50,320,100,30);
        idlabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(idlabel);

        l6= new JLabel(id);
        l6.setBounds(200,320,300,30);
        l6.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(l6);


        edulabel= new JLabel("Education:");
        edulabel.setBounds(50,370,100,30);
        edulabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(edulabel);

        l7= new JLabel(edu);
        l7.setBounds(200,370,300,30);
        l7.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(l7);


        joblabel= new JLabel("Job Post:");
        joblabel.setBounds(50,420,100,30);
        joblabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(joblabel);

        l8= new JLabel(job);
        l8.setBounds(200,420,300,30);
        l8.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(l8);


        bt1=new JButton("Print");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(100,520,100,30);
        bt1.addActionListener(this);
        imglabel.add(bt1);

        bt2=new JButton("Cancel");
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        bt2.setBounds(250,520,100,30);
        bt2.addActionListener(this);
        imglabel.add(bt2);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt1){
            JOptionPane.showMessageDialog(null,"printed successfully");
            frame.setVisible(false);
            FunctionalityPage lp= new FunctionalityPage();
        }
        if(e.getSource()==bt2){
            frame.setVisible(false);
            new view_employee();
        }
    }
}
