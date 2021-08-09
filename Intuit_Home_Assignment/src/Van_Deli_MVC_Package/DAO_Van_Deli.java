package Van_Deli_MVC_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
/*
 * DAO_Van_Deli.java
 * This Data Access Layer class is responsible for execution of queries and retrieving 
 * the data from the database.
 *
 */
public class DAO_Van_Deli {
    private String jdbcURL;
    private String jdbcUserid;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public DAO_Van_Deli (String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUserid = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUserid, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public List<Model_Van_Deli> queryResultsTask1 () throws SQLException {
        List<Model_Van_Deli> listResultTask1 = new ArrayList<>();
         
        String sql = "SELECT TOP 1 WITH TIES m.product_name AS Product_Name, COUNT(*) AS Purchase_Count FROM sales s INNER JOIN menu m ON s.product_id=m.product_id GROUP BY m.product_name ORDER BY COUNT(*) DESC";         
        connect();
        
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String product_name = resultSet.getString("product_name");
            int purchase_count = resultSet.getInt("purchase_count");

            Model_Van_Deli resultRow = new Model_Van_Deli(product_name, purchase_count);
            listResultTask1.add(resultRow);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listResultTask1;
    }
    
    public List<Model_Van_Deli> queryResultsTask2 () throws SQLException, ClassNotFoundException {
        List<Model_Van_Deli> listResultTask2 = new ArrayList<>();
         
        String sql = "SELECT s.customer_id, s.order_date, m.product_name, m.price, Dense_Rank() OVER(PARTITION BY s.customer_id ORDER BY [order_date]) AS [ranking], CASE WHEN s.order_date>=mem.join_date THEN 'Y' ELSE 'N' END AS member FROM sales s LEFT JOIN menu m ON s.product_id=m.product_id LEFT JOIN members mem ON s.customer_id=mem.customer_id ORDER BY s.customer_id, s.order_date";
         
        connect();
        
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String customer_id = resultSet.getString("customer_id");
            String order_date = resultSet.getString("order_date");
            String product_name = resultSet.getString("product_name");
            int price = resultSet.getInt("price");
            String member = resultSet.getString("member");
            int ranking = resultSet.getInt("ranking");
            
            Model_Van_Deli resultRow = new Model_Van_Deli(customer_id, order_date, product_name, price, member, ranking);

            listResultTask2.add(resultRow);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listResultTask2;
    }
}