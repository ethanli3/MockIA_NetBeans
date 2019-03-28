package mockia.data;

import mockia.expenditures.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {

    /**
     * Method that connects to the database
     * @return The connection to the database
     * @throws Exception Throws database connection error
     */
    private static Connection getConnection() throws Exception
    {
        try
        {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/Database";
            String username = "root";
            String password = "root";
            Connection conn = DriverManager.getConnection(url, username, 
                    password);
            System.out.println("Connected");
            return conn;
        }
        catch (Exception e)
        {
            System.out.println("Connection Error: " + e);
        }
        return null;
    }

    /**
     * If there is no table within the database, it creates a new table
     * @throws Exception throws creating database table error
     */
    public static void createTable() throws Exception
    {
        try
        {
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement
                ("CREATE TABLE IF NOT EXISTS dailySpending(id int NOT NULL "
                        + "AUTO_INCREMENT, day varchar(5), month varchar(5), "
                        + "year varchar(5), amountSpent double, "
                        + "type varchar(255), PRIMARY KEY (id))");
            create.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println("Table Error: " + e);
        }
    }

    /**
     * Method that posts the data of an expenditure given a day, month, year,
     * amount spent, and type of String
     * @param day The given day
     * @param month The given month
     * @param year The given year
     * @param amountSpent The amount spent
     * @param type The type of expenditure
     * @throws Exception Throws error collecting data from database
     */
    public static void post(String day, String month, String year, 
            double amountSpent, String type) throws Exception
    {
        try
        {
            Connection con = getConnection();
            PreparedStatement post = con.prepareStatement
                    ("INSERT INTO dailySpending(day, month, year, amountSpent, "
                            + "type) VALUES(?, ?, ?, ?, ?)");
            post.setString(1, day);
            post.setString(2, month);
            post.setString(3, year);
            post.setDouble(4, amountSpent);
            post.setString(5, type);
            post.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println("Post Error: " + e);
        }
    }

    /**
     * Gets all the rows of data from the database to create expenditure objects
     * @return The ArrayList of Expenditures
     * @throws Exception 
     */
    public static ArrayList<Expenditures> createObjects() throws Exception
    {
        ArrayList<Expenditures> listOfSpending = new ArrayList<Expenditures>();
        try
        {
            Connection con = getConnection();
            PreparedStatement get = con.prepareStatement
                    ("SELECT day, month, year, type, amountSpent FROM dailySpending");

            ResultSet result = get.executeQuery();

            while (result.next())
            {
                switch (result.getString("type"))
                {
                    case "Bills" :
                        Expenditures bills =  new Bills(
                        result.getString("type"),
                                result.getString("day"),
                                result.getString("month"),
                                result.getString("year"),
                                result.getInt("amountSpent")) ;
                        listOfSpending.add(bills);
                        break;
                    case "Transport" :
                        Expenditures transport = new Transport(
                                result.getString("type"),
                                result.getString("day"),
                                result.getString("month"),
                                result.getString("year"),
                                result.getInt("amountSpent"));
                        listOfSpending.add(transport);
                        break;
                    case "Lunch" :
                        Expenditures lunch = new Lunch(
                                result.getString("type"),
                                result.getString("day"),
                                result.getString("month"),
                                result.getString("year"),
                                result.getInt("amountSpent"));
                        listOfSpending.add(lunch);
                        break;
                    case "Groceries" :
                        Expenditures groceries = new Groceries(
                                result.getString("type"),
                                result.getString("day"),
                                result.getString("month"),
                                result.getString("year"),
                                result.getInt("amountSpent"));
                        listOfSpending.add(groceries);
                        break;
                    case "Occasional" :
                        Expenditures occasionalExpenses = new OccasionalExpenses(
                                result.getString("type"),
                                result.getString("day"),
                                result.getString("month"),
                                result.getString("year"),
                                result.getInt("amountSpent"));
                        listOfSpending.add(occasionalExpenses);
                        break;
                    default:
                        Expenditures de = new OccasionalExpenses(
                                "Occasional",
                                result.getString("day"),
                                result.getString("month"),
                                result.getString("year"),
                                result.getInt("amountSpent"));
                        listOfSpending.add(de);
                }
            }
        return listOfSpending;
        }
        catch (Exception e)
        {
            System.out.println("Creation Error: " + e);
            return null;
        }
    }
}