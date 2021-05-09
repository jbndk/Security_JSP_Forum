package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.*;
import java.util.ArrayList;


public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
            System.out.println("createUser()");
            // Check if user exists:
            Connection con = Connector.connection();
            String SQL = "INSERT INTO forum.users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
        } catch ( SQLException | ClassNotFoundException ex ) {
            System.out.println("createUser() error");
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            System.out.println("login()");
            Connection con = Connector.connection();
            String SQL = "SELECT role, password FROM forum.users "
                    + "WHERE email=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                System.out.println("Linje 64");
                String role = rs.getString( "role" );
                System.out.println("Linje 66");
                System.out.println("Linje 68");
                User user = new User( email, password, role );
                System.out.println("Linje 70");
                String dbPassword = rs.getString( "password" );
                if (user.verifyPassword(dbPassword)) {
                    return user;
                } else
                    throw new LoginSampleException( "Could not validate user" );
            } else {
                throw new LoginSampleException( "Could not find the user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<User> showAllMembers() throws LoginSampleException  {
        ArrayList<User> customerList= new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM forum.users where role = 'member'";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            User member = null;
            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                member = new User(email, password, role);
                customerList.add(member);
            }

        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }

        return customerList;
    }


}