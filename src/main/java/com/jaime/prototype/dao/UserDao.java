package com.jaime.prototype.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jaime.prototype.domain.User;

public interface UserDao {
    
    public List<String> getUsersForSelection();
    
    public User getUser(int userId);
    
    @Autowired
    public void setDataSource(DataSourceObject dataSourceObject);

}
