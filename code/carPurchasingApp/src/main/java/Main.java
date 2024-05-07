import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Main {
    
    public static Connection conn(){
        try{
            String url = "jdbc:mysql://localhost:3306/car-purchasing-app";
            String username = "root";
            String password = ""; // Provide your MySQL password here
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn; // Return the connection object
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

    public static void main(String[] args) {
        Connection conn = Main.conn(); // Connect to the database
        if (conn != null) {
            System.out.println("Connected to the database");

            // Perform database operations here
            try {
                // Example: Execute a query
                String sql = "SELECT * FROM user ";
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    // Process the result set
                    String columnValue = rs.getString("first-name");
                    System.out.println(columnValue);
                }
                rs.close();
                pst.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            

            // Create an instance of CarSearch and pass the connection object
            CarSearch carSearch = new CarSearch(conn);
            carSearch.setVisible(true);


            // Close the connection when done
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Failed to connect to the database");
        }
    }
}
