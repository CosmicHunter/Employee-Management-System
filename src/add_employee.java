import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_employee implements ActionListener {
    JFrame frame;
    JLabel imglabel;
    JLabel titlelabel,namelabel,agelabel,addresslabel,idlabel,joblabel,eidlabel,fnamelabel,doblabel,phonelabel,edulabel,adharlabel;
    JTextField nametxt,agetxt,adresstxt,idtxt,jobtxt,eidtxt,fnametxt,dobtxt,phonetxt,edutxt,adhartxt;
    JButton bt1,bt2;

    add_employee(){
        frame = new JFrame("Add Employee");
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);

        imglabel = new JLabel();
        imglabel.setBounds(0,0,900,700);
        imglabel.setLayout(null);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        imglabel.setIcon(icon);

        titlelabel = new JLabel("New Employee Details");
        titlelabel.setBounds(320,30,500,50);
        titlelabel.setFont(new Font("serif",Font.ITALIC,25));
        titlelabel.setForeground(Color.black);
        imglabel.add(titlelabel);
        frame.add(imglabel);

        namelabel = new JLabel("Name");
        namelabel.setBounds(50,150,100,30);
        namelabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(namelabel);

        nametxt=new JTextField();
        nametxt.setBounds(200,150,150,30);
        imglabel.add(nametxt);

        fnamelabel = new JLabel("Father's Name");
        fnamelabel.setBounds(400,150,200,30);
        fnamelabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(fnamelabel);

        fnametxt=new JTextField();
        fnametxt.setBounds(600,150,150,30);
        imglabel.add(fnametxt);

        agelabel= new JLabel("Age");
        agelabel.setBounds(50,200,100,30);
        agelabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(agelabel);

        agetxt=new JTextField();
        agetxt.setBounds(200,200,150,30);
        imglabel.add(agetxt);

        doblabel= new JLabel("Date Of Birth");
        doblabel.setBounds(400,200,200,30);
        doblabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(doblabel);

        dobtxt=new JTextField();
        dobtxt.setBounds(600,200,150,30);
        imglabel.add(dobtxt);

        addresslabel= new JLabel("Address");
        addresslabel.setBounds(50,250,100,30);
        addresslabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(addresslabel);

        adresstxt=new JTextField();
        adresstxt.setBounds(200,250,150,30);
        imglabel.add(adresstxt);

        phonelabel= new JLabel("Phone");
        phonelabel.setBounds(400,250,100,30);
        phonelabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(phonelabel);

        phonetxt=new JTextField();
        phonetxt.setBounds(600,250,150,30);
        imglabel.add(phonetxt);

        idlabel= new JLabel("Email Id");
        idlabel.setBounds(50,300,100,30);
        idlabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(idlabel);

        idtxt=new JTextField();
        idtxt.setBounds(200,300,150,30);
        imglabel.add(idtxt);

        edulabel= new JLabel("Education");
        edulabel.setBounds(400,300,100,30);
        edulabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(edulabel);

        edutxt=new JTextField();
        edutxt.setBounds(600,300,150,30);
        imglabel.add(edutxt);

        joblabel= new JLabel("Job Post");
        joblabel.setBounds(50,350,100,30);
        joblabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(joblabel);

        jobtxt=new JTextField();
        jobtxt.setBounds(200,350,150,30);
        imglabel.add(jobtxt);


        adharlabel= new JLabel("Aadhar No");
        adharlabel.setBounds(400,350,100,30);
        adharlabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(adharlabel);

        adhartxt=new JTextField();
        adhartxt.setBounds(600,350,150,30);
        imglabel.add(adhartxt);

        eidlabel= new JLabel("Employee Id");
        eidlabel.setBounds(50,400,150,30);
        eidlabel.setFont(new Font("serif",Font.BOLD,20));
        imglabel.add(eidlabel);

        eidtxt=new JTextField();
        eidtxt.setBounds(200,400,150,30);
        imglabel.add(eidtxt);

        bt1 = new JButton("Submit");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(250,550,150,40);

        imglabel.add(bt1);

        bt2=new JButton("Cancel");
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        bt2.setBounds(450,550,150,40);

        imglabel.add(bt2);

        frame.add(imglabel);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        frame.setVisible(true);
        frame.setSize(900,700);
        frame.setLocation(400,150);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

    }





    @Override
    public void actionPerformed(ActionEvent e) {
            String name = nametxt.getText();
            String age = agetxt.getText();
            String address =adresstxt.getText();
            String id = idtxt.getText();
            String job = jobtxt.getText();
            String eid = eidtxt.getText();
            String fname = fnametxt.getText();
            String dob = dobtxt.getText();
            String phone = phonetxt.getText();
            String edu = edutxt.getText();
            String adhar =adhartxt.getText();
            if(e.getSource() == bt1){
                try{
                    conn conn_obj = new conn();
                    String query = "insert into employee values('"+name+"','"+fname+"','"+age+"','"+dob+"','"+address+"','"+phone+"','"+id+"','"+edu+"','"+job+"','"+adhar+"','"+eid+"')";
                    conn_obj.stmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                    frame.setVisible(false);
                    new FunctionalityPage();
                }catch(Exception ee){
                    System.out.println("The error is:"+ee);
                }
            }else if(e.getSource() == bt2){
                frame.setVisible(false);
                new FunctionalityPage();
            }
        }

}
