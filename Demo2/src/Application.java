import javax.swing.*;
import java.sql.*;


public class Application {

    private static Application instance;   // Singleton pattern

    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }
    // Main components of this application

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    private DataAccess dataAdapter;

    // Create the Product View and Controller here!

    private ProductView productView = new ProductView();

    private Profile profile = new Profile();//new addition

    private CheckoutScreen checkoutScreen = new CheckoutScreen();

    private MainScreen mainScreen = new MainScreen();

    private Photo photo = new Photo();




    public MainScreen getMainScreen() {
        return mainScreen;
    }

    public ProductView getProductView() {
        return productView;
    }

    public CheckoutScreen getCheckoutScreen() {
        return checkoutScreen;
    }

    private ProductController productController;

    public ProductController getProductController() {
        return productController;
    }

    private CheckoutController checkoutController;

    public CheckoutController getCheckoutController() {
        return checkoutController;
    }

    public Profile getProfile() {return profile;}

    public Photo getPhoto() {return photo;}

    public DataAccess getDataAdapter() {
        return dataAdapter;
    }





    private void initializeDatabase(Statement stmt) throws SQLException {
        // create the tables and insert sample data here!

        //stmt.execute("create table Product (ProductID int PRIMARY KEY, ProductName char(30), Price double, Quantity double,)");
        //stmt.execute("create table Order (ProductID int PRIMARY KEY, ProductName char(30), Price double, Quantity double)");


        // stmt.execute("create table Product (ProductID int PRIMARY KEY, ProductName char(30), Price double, Quantity double, Tax double,"
        // + "Vendor char(30), Expiration int, )");
        //    stmt.execute("create table Order (ProductID int PRIMARY KEY, ProductName char(30), Price double, Quantity double)");


    }

    private Application() {
        // create SQLite database connection here!


        try {
            Class.forName( "org.sqlite.JDBC" );
            connection = DriverManager.getConnection( "jdbc:sqlite:store.db" );
            Statement stmt = connection.createStatement();
            if (!stmt.executeQuery( "select * from product" ).next()) // product table do not exist
                initializeDatabase( stmt );


        } catch (ClassNotFoundException ex) {
            System.out.println( "SQLite is not installed. System exits with error!" );
            System.exit( 1 );
        } catch (SQLException ex) {
            System.out.println( "SQLite database is not ready. System exits with error!" + ex.getMessage() );

            System.exit( 2 );
        }



       /*  try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8080/RETAIL","root"," ");
            Statement stmt = connection.createStatement();
            if (!stmt.executeQuery("select * from product").next()) // product table do not exist
                initializeDatabase(stmt);


        }
        catch (ClassNotFoundException ex) {
            System.out.println("SQLite is not installed. System exits with error!");
            System.exit(1);
        }

        catch (SQLException ex) {
            System.out.println("SQLite database is not ready. System exits with error!" + ex.getMessage());

            System.exit(2);
        } */


        // Create data adapter here!
        dataAdapter = new DataAccess( connection );

        //Login Screen is here!

        productController = new ProductController( productView, dataAdapter );

        checkoutController = new CheckoutController( checkoutScreen, dataAdapter );
    }


    public static void main(String[] args) {
        Application.getInstance().getMainScreen().setVisible(true);
    }

 
   }

