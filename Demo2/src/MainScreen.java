import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class MainScreen extends JFrame {

    private JButton btnCheckout = new JButton( "Checkout" );
    private JButton btnManage = new JButton( "Manage Product" );
    private JButton btnSettings = new JButton( "Profile" ); //new addition
    //private JButton btnLogin  = new JButton("Login"); //new addition
    User usr = new User();

    public MainScreen() {
        String username = JOptionPane.showInputDialog( null, "Enter Your Password" );
        String password = JOptionPane.showInputDialog( null, "Enter your password" );
        usr.setUserName( username );//set username
        usr.setUserPass( password );//ser password
        this.setLayout( new BoxLayout( this.getContentPane(), BoxLayout.Y_AXIS ) );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize( 600, 300 );

        btnManage.setPreferredSize( new Dimension( 120, 50 ) );
        btnCheckout.setPreferredSize( new Dimension( 120, 50 ) );
        btnSettings.setPreferredSize( new Dimension( 120, 50 ) );//new addition
        //btnLogin.setPreferredSize(new Dimension(120, 120));//new addition


        JLabel title = new JLabel( "Retail System Demo" );
        title.setFont( new Font( "Sans Serif", Font.BOLD, 24 ) );
        JPanel panelTitle = new JPanel();
        panelTitle.add( title );
        this.getContentPane().add( panelTitle );

        JPanel panelButton = new JPanel();
        panelButton.add( btnCheckout );
        panelButton.add( btnManage );
        panelButton.add( btnSettings );//new addition

        //JPanel panelLoginBtn = new JPanel();
        //panelButton.add(btnLogin);

        this.getContentPane().add( panelButton );

        //this.getContentPane().add(panelLoginBtn);

       /* btnLogin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showInputDialog( null, "Enter Username" );
            }
        }); */

        btnCheckout.addActionListener( new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getCheckoutScreen().setVisible( true );
            }
        } );


        btnManage.addActionListener( new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getProductView().setVisible( true );
            }
        } );

        btnSettings.addActionListener( new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getProfile().setVisible( true );
            }
        } );
    }


}
