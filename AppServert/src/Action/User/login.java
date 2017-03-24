package Action.User;
import MySql.MySqlConnection;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by YLRS on 17/3/23.
 */
public class login extends ActionSupport{

    private String  mobile;

    private Map<String,Object> jsonData;

    public String userloginAction() {

        jsonData = new HashMap<String,Object>();

        try{

            System.out.println(mobile);

            ResultSet rs = null;

            String sql = "select * from user where mobile = " + mobile;

            rs =  MySqlConnection.getConnection().createStatement().executeQuery(sql);

            List<Map<String,Object>> userlist = new ArrayList<Map<String,Object>>();

            while (rs.next()) {

                String username = rs.getString("username");

                String mobile = rs.getString("mobile");

                HashMap map = new HashMap();

                map.put("username",username);

                map.put("mobile",mobile);

                userlist.add(map);
            }

            jsonData.put("list",userlist);

            jsonData.put("code","200");

            rs.close();
        }
        catch (Exception ex){

            ex.printStackTrace();

            return null;
        }

        finally {

        }

        return Action.SUCCESS;
    }

    public Map<String,Object> getJsonData() {

        return jsonData;
    }

    public void setJsonData(Map<String,Object> jsonData) {

        this.jsonData = jsonData;
    }

    public String getMobile(){

        return mobile;
    }

    public void setMobile(String mobile){

        this.mobile = mobile;
    }
}
