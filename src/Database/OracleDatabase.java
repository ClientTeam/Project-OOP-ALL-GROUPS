package Database;
//importing the mysql 
import java.sql.*;  
import java.util.ArrayList;
import java.util.HashMap;
 
public class OracleDatabase {
    private Connection con;
    
    public OracleDatabase()
    {
        con = null;
    }
    
    public ArrayList<HashMap<String, Object>> execute(String query)
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");  // getting class from the ojdbc package(DONOT FORGET TO IMPORT OJBDC 7.0 JAR
            con = DriverManager.getConnection("jdbc:oracle:thin:@dilbert.humber.ca:1521:grok", "n01014819", "oracle"); // TELLING WHERE THE CONNECTION IS TO
            ResultSet rs = con.createStatement().executeQuery(query); // Executing the query user provided and getting resultset
            ResultSetMetaData meta = rs.getMetaData(); // getting what kind of data i am getting.

            int col_count = meta.getColumnCount(); // getting number of rows recieved from metadata
            ArrayList<String> column_names = new ArrayList<>(); //getting the column name we are recieving
            /**
             * The below code just adds the column names to column_name array so that we can easily identify the column and get data
             */
            for (int i = 0; i < col_count; i++) {
                    column_names.add(meta.getColumnName((i + 1)));

            }
            /**
             * The code above just adds the column names to column_name array so that we can easily identify the column and get data
             * This is used to easily access the information required later
             */
            
            ArrayList<HashMap<String, Object>> data = new ArrayList<>(); // package we will send later to the class
            // the below code adds the data to the data ArrayHashmap(2 Sided array for storage of all data)- DONOT MESS WITH THIS AS IT WILL DAMAGE THE DATA OUTPUT
            while (rs.next()) {
                    HashMap<String, Object> map = new HashMap<>();
                    for (int i = 0; i < col_count; i++) {
                            map.put(column_names.get(i), rs.getString((i + 1)));
                    }

                    data.add(map);
            }
            // the above code adds the data to the data ArrayHashmap(2 Sided array for storage of all data)- DONOT MESS WITH THIS AS IT WILL DAMAGE THE DATA OUTPUT
            return data; // return data
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println(ex.getMessage()); // only for debugging the connection
        }
        finally {
            // close connection and do other cleaning jobs if neccesary
            if (con != null) {
                try {
                        con.close();
                } catch (SQLException e) {

                }
            }
        }
        return null;
    }
    
    public boolean executeDML(String query, int number_of_changes_expected)
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");  // getting class from the ojdbc package
            con = DriverManager.getConnection("jdbc:oracle:thin:@dilbert.humber.ca:1521:grok", "n01014819", "oracle");// TELLING WHERE THE CONNECTION IS TO
            return con.createStatement().executeUpdate(query) == number_of_changes_expected; // executes the query the gives me the result in boolean whether added or not
        }
        catch(ClassNotFoundException | SQLException ex)
        {
           // System.out.println(ex.getMessage()); // only for debugging the connection
        }
        finally {
            if (con != null) {
                try {
                        con.close();
                } catch (SQLException e) {

                }
            }
        }
        return false;
    }
    
}