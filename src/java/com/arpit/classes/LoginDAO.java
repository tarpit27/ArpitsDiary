package com.arpit.classes;

import java.sql.*;

/**
 *
 * @author arpit
 */
public class LoginDAO {

    public static UserModel status(UserModel bean) {
        String username = bean.getUsername();
        String password = bean.getPassword();
        String sql = "select * from user where username='"
                + username
                + "' and password='"
                + password
                + "';";
        UserModel userBean = bean;
        Connection con = Connector.getConnection();
        Statement st = null;
        ResultSet rs = null;
        try{
            st = con.createStatement();
            rs = st.executeQuery(sql);
            boolean more = rs.next();
            if(more){
                bean.setIsValid(true);
            }
            st.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return userBean;
    }

}
