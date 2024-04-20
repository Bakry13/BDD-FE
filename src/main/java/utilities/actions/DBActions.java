package utilities.actions;

import java.sql.*;

public class DBActions {
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
    private static String USER = "root";
    private static String PASSWORD = "";
    private static String sqlDriver = "com.mysql.cj.jdbc.Driver";
    private static Connection connection;
    private static Connection openConnection() {
        try {
            System.out.println("trying to connect to mysql server...");
            //create jdbc connection obj and load class
            Class.forName(sqlDriver);
            Thread.sleep(10);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException | InterruptedException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ResultSet runSQLQuery(String query) {
        if (connection == null)
            connection = openConnection();
        ResultSet rs = null;
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(query);
            System.out.println("query : \"" + query + "\" is executed! ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: ColumnIndex is not valid; OR database access error occurs; " +
                    "OR this method is called on a closed result set.");
        }
        return rs;
    }

    public static void main(String[] args) throws SQLException {
        ResultSet rs = runSQLQuery("Select Host from user");
//        //print database table records
        while(rs.next())
        {
        System.out.println(rs.getString(1));
        }
//        runSQLQuery("commit");
    }
}
