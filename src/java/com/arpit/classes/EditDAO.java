
package com.arpit.classes;

/**
 *
 * @author arpit
 */

import java.sql.*;

public class EditDAO {
    private static boolean isUpdate = false;
    private static String sql = null;
    public static boolean editDiary(String title, String username, String diary){
        Connection con = Connector.getConnection();
        sql = "update content set diary=? where title=? and username=?;";
        try{
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, diary);
            st.setString(2, title);
            st.setString(3, username);
            int i = st.executeUpdate();
            
            if(i != 0){
                isUpdate = true;
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return isUpdate;
    } //[end editDiary]
} //[end class]
