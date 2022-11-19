package test_sql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author NT
 */
public class DataProvider {

    private static String url = "jdbc:sqlserver://localhost:1433;database=DoAn_QLKho";
    private static String user = "sa";
    private static String pass = "12345678";
    
    private Connection conn = null;
    private static DataProvider intance;

    public static DataProvider getIntance() {
        if (intance == null) {
            intance = new DataProvider();
        }
        return intance;
    }
    public Connection getconn()
    {
        return conn;
    }
    
    // xu ly ngoai le khi tuong tac voi csdl 

    public void displayError(SQLException ex) {
        System.out.println(" Error Message:" + ex.getMessage());
        System.out.println(" SQL State:" + ex.getSQLState());
        System.out.println(" Error Code:" + ex.getErrorCode());
    }

    public void open() {// mo ket noi den csdl 
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);//tao ket noi den co so du lieu 
            System.out.println("Ket noi thanh cong");
        } catch (SQLException ex) {// xu ly ngoai le 
            displayError(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Thieu JDBC");
        }
    }

    public void close() {// dong ket noi co so du lieu 
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            displayError(ex);
        }
    }

    public Connection getConnect() {
        return conn;
    }
    //tao va thuc thi cac cau lenh sql 
    // cung cap thong tin trich rut tu csdl va cho phep truy xuat tung dong du lieu 
}
    