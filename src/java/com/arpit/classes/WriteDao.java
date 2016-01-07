
package com.arpit.classes;

/**
 *
 * @author arpit
 */

import java.sql.*;

public class WriteDao {
    
    public static boolean writeData(String title, String date, String diary, String username){
        boolean isWritten = false;
        Connection con = Connector.getConnection();
        try{
            PreparedStatement st = con.prepareStatement("insert into content(title,diary,date,username) values(?,?,?,?);");
            st.setString(1, title);
            st.setString(2, diary);
            st.setString(3, date);
            st.setString(4, username);
            
            int i = st.executeUpdate();
            
            if(i!=0){
                isWritten = true;
            }
            
            st.close();
            con.close();
        } catch(Exception e){
            e.printStackTrace();
        }
            
        return isWritten;
    }
}
