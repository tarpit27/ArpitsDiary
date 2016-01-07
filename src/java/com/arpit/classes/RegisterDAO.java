
package com.arpit.classes;

/*
 * @author arpit
 */
import java.sql.*;

public class RegisterDAO {
    public static boolean write(String name, String username, String email, String password){
        boolean is = false;
        
        Connection con = Connector.getConnection();
        PreparedStatement st = null;
        
        try{
            String sql = "insert into user(name,username,email,password)"
                    + "values(?,?,?,?)";
            
            st = con.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, username);
            st.setString(3, email);
            st.setString(4, password);
            
            int i = st.executeUpdate();
            if(i!=0){
                is = true;
            }
            st.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return is;
    }
}
