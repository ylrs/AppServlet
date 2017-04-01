package MySql;
import java.sql.*;
/**
 * Created by YLRS on 17/3/23.
 */
public class MySqlConnection {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/PinTu";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "as19890413";

    // 连接实例
    public  Connection conn = null;

    public MySqlConnection() throws Exception {


    }
    private  void init() {

        try{

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

        }
        catch (Exception ex){

             ex.printStackTrace();
        }
    }
    //获得连接对象
    public  Connection getConnection(){

        System.out.println("conn");

        try {
            if (conn == null){

                init();

                System.out.println("initConnect");

            }
        }
        catch (Exception ex){


        }

        return  conn;
    }

    public void CloseConnection() throws SQLException{

        try{

            conn.close();
        }
        catch (Exception ex){

            ex.printStackTrace();
        }

    }

    //关闭连接
    public  void CloseConnection(ResultSet rs,Statement st,PreparedStatement pstmt) throws SQLException{
        try{

            if (rs != null){

                rs.close();
            }
            if (st != null){

                st.close();
            }
            if (pstmt != null){

                pstmt.close();
            }

            conn.close();
        }
        catch (Exception ex){

            ex.printStackTrace();
        }

    }

}
