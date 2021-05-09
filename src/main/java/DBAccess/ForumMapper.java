package DBAccess;

import FunctionLayer.Category;
import FunctionLayer.LoginSampleException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ForumMapper {

    public static ArrayList<Category> getCategories() throws LoginSampleException {

        String sql = "SELECT * FROM forum.categories;";
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

}