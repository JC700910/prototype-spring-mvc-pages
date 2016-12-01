package com.jaime.prototype.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.jaime.prototype.dao.DataSourceObject;
import com.jaime.prototype.dao.UserDao;
import com.jaime.prototype.domain.User;

public class UserDaoImpl implements UserDao {

   
    private DataSourceObject dataSourceObject;
    
    
 

    public List<User> getUsersForSelection() {

        List<User> userList = new LinkedList<User>();

        try {
            
            DataSource dataSource = dataSourceObject.getDataSource();
            
            Connection con = dataSource.getConnection();

            Statement stmt = con.createStatement();

            String sql = "select username,user_id from jchester.USER_ACCOUNT";

            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                
                User user = new User();
                
                user.setUserName(rset.getString(1));
                user.setUserId(rset.getInt(2));
                
                
                userList.add(user);
            }

            rset.close();
            stmt.close();
            con.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userList;
    }

    public User getUser(int userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Autowired
    public void setDataSource(DataSourceObject dataSourceObject) {
        this.dataSourceObject = dataSourceObject;
        
    }

}
