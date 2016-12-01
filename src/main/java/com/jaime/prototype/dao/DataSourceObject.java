package com.jaime.prototype.dao;

import javax.sql.DataSource;

public interface DataSourceObject {

    public DataSource getDataSource();
    
    public void setDataSource(DataSource dataSource);
}
