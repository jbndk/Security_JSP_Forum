package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.Post;

import java.sql.*;
import java.util.ArrayList;

public class OrderMapper {


    public static ArrayList<Order> showAllOrders() throws LoginSampleException, ClassNotFoundException {
        ArrayList<Order> orderList = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cupcake.orders";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            Order order = null;
            while (rs.next()) {
                int id = rs.getInt("orderID");
                int uid = rs.getInt("userID");
                double px = rs.getDouble("price");
                Timestamp time = rs.getTimestamp("timest");
                order = new Order(id,uid,px,time);
                orderList.add(order);
            }

        } catch ( SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }

        return orderList;
    }
    public static int lastOrderID() throws LoginSampleException {
        int orderID = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT MAX(orderID) as id FROM cupcake.orders";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                orderID = rs.getInt("id");
            }
            return orderID;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<Post> showAllPosts() throws LoginSampleException, ClassNotFoundException {
        ArrayList<Post> posts = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cupcake.posts";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("postID");
                String category = rs.getString("category");
                String content = rs.getString("content");
                String author = rs.getString("author");
                Timestamp time = rs.getTimestamp("created");
                Post p = new Post(id, category, content, author, time);
                posts.add(p);
            }

        } catch ( SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }

        return posts;
    }

    public static void addPost(Post p) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String sql = "INSERT INTO cupcake.posts (category, content, author) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( sql );
            ps.setString( 1, p.getCategory());
            ps.setString( 2, p.getContent());
            ps.setString( 3, p.getAuthor());

            ps.executeUpdate();

        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static void createOrder(Order order) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String sql = "INSERT INTO cupcake.orders (userID, price) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement( sql );
            ps.setInt( 1, order.getCustomerID());
            ps.setDouble( 2, order.getPrice() );

            ps.executeUpdate();

        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
    public static void insertItems(int odaID, int top, int bottom, int qty) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String sql = "INSERT INTO cupcake.items (orderID,topID, bottomID,quantity) VALUES (?, ?, ?,?)";
            PreparedStatement ps = con.prepareStatement( sql );
            ps.setInt( 1, odaID );
            ps.setInt( 2, top );
            ps.setInt( 3, bottom);
            ps.setInt( 4, qty );

            ps.executeUpdate();

            } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }


}
