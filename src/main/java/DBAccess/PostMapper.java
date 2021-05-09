package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Post;

import java.sql.*;
import java.util.ArrayList;

public class PostMapper {

    public static ArrayList<Post> showAllPosts() throws LoginSampleException, ClassNotFoundException {
        ArrayList<Post> posts = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM forum.posts";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("postID");
                String category = rs.getString("category");
                String content = rs.getString("content");
                String author = rs.getString("author");
                String filePath = rs.getString("filePath");
                Timestamp time = rs.getTimestamp("created");
                Post p = new Post(id, category, content, author, filePath, time);
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
            String sql = "INSERT INTO forum.posts (category, content, author, filePath) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( sql );
            ps.setString( 1, p.getCategory());
            ps.setString( 2, p.getContent());
            ps.setString( 3, p.getAuthor());
            ps.setString(4, p.getFilePath());

            ps.executeUpdate();

        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
}
