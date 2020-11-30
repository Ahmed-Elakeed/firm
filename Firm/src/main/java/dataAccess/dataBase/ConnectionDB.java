package dataAccess.dataBase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionDB {
    private FileReader FIS;
    private static Properties prop=null;
    private static Connection conn=null;
    private static Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);;

    public ConnectionDB() {
        try {
            FIS = new FileReader("src/main/resources/configurations.properties");
            try {
                prop=new Properties();
                prop.load(FIS);
                try {
                    Class.forName(prop.getProperty("DriverClass"));
                } catch (ClassNotFoundException e) {
                    logger.log(Level.SEVERE,"Failed To Find Driver Class");
                }
            } catch (IOException e) {
                logger.log(Level.SEVERE,"Failed to load properties file");
            }
        }catch (FileNotFoundException fnf){
            logger.log(Level.SEVERE,"File Not Found");
        }
    }
    public static Connection getConnection(){
        if(prop==null){
            new ConnectionDB();
        }
        try {
            if (conn == null || conn.isClosed()) {
               conn=DriverManager.getConnection(prop.getProperty("PrefixURL")+prop.getProperty("DataBaseName"),prop.getProperty("UserName"),prop.getProperty("Password"));
            }
        } catch (SQLException throwable) {
            logger.log(Level.SEVERE,"Failed to get a connection");
        }
        return conn;
    }


    public static void closeConnection(){
        try {
            if (conn == null || conn.isClosed()) {
                return;
            }else {
                conn.close();
            }
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE,"Failed to close the connection");
        }
    }
}
