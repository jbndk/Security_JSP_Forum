package DBAccess;

import FunctionLayer.Bottom;
import FunctionLayer.Category;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Topping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CupcakeMapper {


    public static String getBottomName(int id) throws LoginSampleException {
        String name = "";
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT name FROM cupcake.bottoms WHERE bottomID = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs == null) {
                return null;
            } else {
                rs.next();
                name = rs.getString("name");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return name;
    }

    public static String getToppingName(int id) throws LoginSampleException {
        String name = "";
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT name FROM cupcake.toppings WHERE topID = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs == null) {
                return null;
            } else {
                rs.next();
                name = rs.getString("name");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return name;
    }
    public static Double getToppingPrice(int id) throws LoginSampleException {
        Double price = 0.0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT price FROM cupcake.toppings WHERE topID = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs == null) {
                return null;
            } else {
                rs.next();
                price = rs.getDouble("price");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return price;
    }
    public static Double getBottomPrice(int id) throws LoginSampleException {
        Double price = 0.0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT price FROM cupcake.bottoms WHERE bottomID = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs == null) {
                return null;
            } else {
                rs.next();
                price = rs.getDouble("price");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return price;
    }

    public static int getBottomID(String name) throws LoginSampleException {

        String sql = "SELECT * FROM cupcake.bottoms WHERE name = ?;";

        int bottomID = 0;

        try {
            Connection con = Connector.connection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet res = pstmt.executeQuery();

            if (res == null) {
                return 0;
            } else {
                res.next();
                bottomID = res.getInt("bottomID");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

        return bottomID;

    }
    public static int getToppingID(String name) throws LoginSampleException {

        String sql = "SELECT * FROM cupcake.toppings WHERE name = ?;";

        int toppingID = 0;

        try {
            Connection con = Connector.connection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet res = pstmt.executeQuery();

            if (res == null) {
                return 0;
            } else {
                res.next();
                toppingID = res.getInt("topID");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

        return toppingID;

    }

    public static ArrayList<Category> getCategories() throws LoginSampleException {

        String sql = "SELECT * FROM cupcake.categories;";
        ArrayList<Category> categories = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();

            if (res == null) {
                return null;
            } else {
                while (res.next()) {
                    categories.add(new Category(res.getString("category")));
                }
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

        return categories;
    }

    public static ArrayList<Bottom> getBottoms() throws LoginSampleException {

        String sql = "SELECT * FROM cupcake.bottoms;";
        ArrayList<Bottom> bottomList = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();

            if (res == null) {
                return null;
            } else {
                while (res.next()) {
                    bottomList.add(new Bottom(res.getInt("bottomID"), res.getString("name"), res.getDouble("price")));
                }
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

        return bottomList;
    }

    public static ArrayList<Topping> getTops() throws ClassNotFoundException, LoginSampleException {

        String sql = "SELECT * FROM cupcake.toppings;";
        ArrayList<Topping> topList = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();

            if (res == null) {
                return null;
            } else {
                while (res.next()) {
                    topList.add(new Topping(res.getInt("topID"), res.getString("name"), res.getDouble("price")));
                }
            }

        } catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

        return topList;

    }


}