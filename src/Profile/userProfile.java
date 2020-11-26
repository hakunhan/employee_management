import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userProfile extends JFrame implements ActionListener
{
    public static String name;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    Button b1,b2,button;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try {
                    userProfile frame = new userProfile();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public userProfile()
    {
        setResizable(false);
        //System.out.println(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblProfile = new JLabel("Profile");
        lblProfile.setFont(new Font("Aerial", Font.PLAIN, 36));
        lblProfile.setBounds(152, 11, 109, 44);
        contentPane.add(lblProfile);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Aerial", Font.PLAIN, 16));
        lblName.setBounds(10, 72, 49, 31);
        contentPane.add(lblName);

        textField = new JTextField();
        textField.setBounds(101, 79, 200, 20);
        textField.setEditable(false);
        contentPane.add(textField);
        textField.setColumns(10);


        JLabel lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Aerial", Font.PLAIN, 16));
        lblAddress.setBounds(10, 110, 83, 14);
        contentPane.add(lblAddress);

        textField_1 = new JTextField();
        textField_1.setBounds(101, 110, 200, 20);
        textField_1.setEditable(false);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblPhoneNo = new JLabel("Phone Number");
        lblPhoneNo.setFont(new Font("Aerial", Font.PLAIN, 16));
        lblPhoneNo.setBounds(10, 138, 88, 20);
        contentPane.add(lblPhoneNo);

        textField_2 = new JTextField();
        textField_2.setBounds(101, 141, 200, 20);
        textField_2.setEditable(false);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Aerial", Font.PLAIN, 16));
        lblEmail.setBounds(10, 179, 83, 14);
        contentPane.add(lblEmail);

        textField_3 = new JTextField();
        textField_3.setBounds(101, 180, 200, 20);
        textField_3.setEditable(false);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        b1 = new Button("Back");
        b1.addActionListener(this);
        b1.setFont(new Font("Aerial", Font.PLAIN, 12));
        b1.setBounds(61, 228, 89, 23);
        contentPane.add(b1);

        b2 = new Button("Exit");
        b2.addActionListener(this);
        b2.setFont(new Font("Aerial", Font.PLAIN, 12));
        b2.setBounds(172, 229, 89, 23);
        contentPane.add(b2);

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/account",
                    "root", "hideonbush1969");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from employee where name='"+name+"'");
            if(rs.next())
            {
                textField.setText(rs.getString(1));
                textField_1.setText(rs.getString(2));
                textField_2.setText(rs.getString(3));
                textField_3.setText(rs.getString(4));

            }
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("Class not found");
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }

        button = new Button("Change pasword \r\n");
        button.setBackground(UIManager.getColor("Button.disabledForeground"));
        button.setFont(new Font("Aerial", Font.PLAIN, 12));
        button.setBounds(300, 228, 120, 23);
        contentPane.add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangePassword bo = new ChangePassword();
                bo.setTitle("Employee-Login");
                bo.setVisible(true);
            }
        });


    }
    public userProfile(String n)
    {
        name=n;

    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        Button bb=(Button)ae.getSource();
        if(bb==b1)
        {
            dispose();
            Login_Welcome m=new Login_Welcome(); //gets us back to Login_Welcome page
            m.setVisible(true);
        }
        if(bb==b2)
        {
            System.exit(0);
        }

    }

}



