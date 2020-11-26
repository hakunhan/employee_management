package Profile;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class userLogin extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;

    /**
     * Launch the application
     */
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    userLogin frame = new userLogin();
                    frame.setVisible(true);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame
     */
    public userLogin(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1000, 600);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Aerial", Font.PLAIN, 46));
        lblNewLabel.setBounds(430, 15, 270, 90);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Aerial", Font.PLAIN, 32));
        textField.setBounds(480, 170, 280, 70);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Aerial", Font.PLAIN, 32));
        passwordField.setBounds(480, 285, 280, 70);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Aerial", Font.PLAIN, 32));
        lblUsername.setBounds(250, 165, 190, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBackground(Color.BLACK);
        lblPassword.setForeground(Color.CYAN);
        lblPassword.setFont(new Font("Aerial", Font.PLAIN, 32));
        lblPassword.setBounds(250, 285, 190, 52);
        contentPane.add(lblPassword);

        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Aerial", Font.PLAIN, 25));
        btnNewButton.setBounds(545, 390, 160, 73);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = passwordField.getText();
                try{
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/account",
                            "root", "hideonbush1969");
                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select username, password from employee where username=? and password=?");
                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if(rs.next()){
                        dispose();
                        Login_Welcome ah = new Login_Welcome(userName);
                        ah.setTitle("Welcome");
                        ah.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in!");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password!");
                    }
                } catch (SQLException sqlException){
                    sqlException.printStackTrace();
                }
            }
        });
        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
    }
}
