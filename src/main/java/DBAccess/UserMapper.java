package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import java.sql.*;
import java.util.ArrayList;


/**
 @author claes
 */

public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO cupcake.users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setUserID( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT userID, role FROM cupcake.users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "userID" );
                User user = new User( email, password, role );
                user.setUserID( id );

                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void createEmp( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO cupcake.users (email, password, role, balance) VALUES (?, ?, ?,?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.setDouble( 4, user.getBalance() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setUserID( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
    public static void updateBalance(int userID, double beloebTilIndsaettelse) {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE cupcake.users SET balance = balance + ? WHERE userID = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, " " + beloebTilIndsaettelse);
            ps.setString(2, " " + userID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static double getBalance(int userID) throws SQLException {
        double balance = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT balance FROM cupcake.users "
                    + "WHERE userID=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                balance = rs.getDouble("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return balance;
    }
    public static void payOrder(Double amount, int userID) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE cupcake.users SET balance = balance - ? WHERE userID = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setDouble(1, amount);
            ps.setInt(2, userID);
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


    public static double showBalance(String email) throws SQLException {
        double balance = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT balance FROM cupcake.users "
                    + "WHERE email=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                balance = rs.getDouble("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return balance;
    }
    public static ArrayList<User> showAllCustomers() throws LoginSampleException  {
        ArrayList<User> customerList= new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cupcake.users where role = 'customer'";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            User customer = null;
            while (rs.next()) {
                int id = rs.getInt("userID");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                double balance = rs.getDouble("balance");
                customer = new User(id,email, password, role, balance);
                customerList.add(customer);
            }

        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }

        return customerList;
    }


}