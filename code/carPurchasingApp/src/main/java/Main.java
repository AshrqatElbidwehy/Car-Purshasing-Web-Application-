import app.Login;
public class Main {
    
   
    public static void main(String[] args) {
<<<<<<< HEAD
      
        new Login().setVisible(true);
     
=======
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
                    String columnValue = rs.getString("full-name");
                    System.out.println(columnValue);
                }
                rs.close();
                pst.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            

            // Create an instance of CarSearch and pass the connection object
            CarListing carListing = new CarListing();
            carListing.setVisible(true);
            //CarSearch carSearch = new CarSearch(conn);
            //carSearch.setVisible(true);


            // Close the connection when done
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Failed to connect to the database");
        }
>>>>>>> feca738d70f715c50f2bf8bd8a665c20831d5aeb
    }
}