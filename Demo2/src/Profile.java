import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class Profile extends JFrame {

    private JButton btnChangePassword = new JButton( "Change Password" );
    private JButton btnAddUser = new JButton( "Add User" );
    private JButton btnViewReport = new JButton( "Report" ); //new addition
    private JButton btnChangePicture = new JButton( "Profile Picture" );


    private DataAccess dataAdapter; // to save and load authentication information

    public Profile() {
        this.setLayout( new BoxLayout( this.getContentPane(), BoxLayout.Y_AXIS ) );
        this.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
        this.setSize( 600, 300 );

        btnChangePassword.setPreferredSize( new Dimension( 120, 50 ) );
        btnAddUser.setPreferredSize( new Dimension( 120, 50 ) );
        btnViewReport.setPreferredSize( new Dimension( 120, 50 ) );//new addition
        btnChangePicture.setPreferredSize( new Dimension( 120, 50 ) );//new addition


        JLabel title = new JLabel( "Settings" );
        title.setFont( new Font( "Sans Serif", Font.BOLD, 24 ) );
        JPanel panelTitle = new JPanel();
        panelTitle.add( title );
        this.getContentPane().add( panelTitle );

        JPanel panelButton = new JPanel();
        panelButton.add( btnChangePassword );
        panelButton.add( btnAddUser );
        panelButton.add( btnViewReport );//new addition
        //panelButton.add(btnViewReport);
        panelButton.add( btnChangePicture );

        this.getContentPane().add( panelButton );

        btnChangePassword.addActionListener( new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
                String usrname = JOptionPane.showInputDialog( "Please Enter Your Username" );
                String pass = JOptionPane.showInputDialog( "Please Enter Your Passsword" );
                User usr = new User();
                usr.setUserName( usrname );

                Scanner scan = null;
                File input = new File( "/Users/DOMINUS/Desktop/Comp3700/Demo2/password.txt" );
                try {
                    scan = new Scanner( input );

                    while (scan.hasNext()) {
                        String name = scan.next();
                        String passW = scan.next();
                        String type = scan.next();

                        if (usrname == name ){
                            //change password
                        }


                    }
                    scan.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } );


        btnAddUser.addActionListener( new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
                String usrname = JOptionPane.showInputDialog( "Please Enter Your Username" );
                String pass = JOptionPane.showInputDialog( "Please Enter Your Passsword" );
                JOptionPane.showMessageDialog(null, "New User Added" );
                User new1 = new User(usrname, 4, 2,pass);
                //Application.getInstance().getProductView().setVisible( true );
            }
        } );

        btnChangePicture.addActionListener( new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getPhoto().setVisible(true);
            }
        } );


       btnViewReport.addActionListener( new ActionListener() { // when controller is simple, we can declare it on the fly
        public void actionPerformed(ActionEvent e) {
            //Application.getInstance().getPhoto().setVisible(true);
        }
    } );


} }
