package com.jaime.prototype.dao.impl;

import javax.sql.DataSource;

import com.jaime.prototype.dao.DataSourceObject;

public class DataSourceObjectImpl implements DataSourceObject {

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    


}
