package com.jaime.prototype.spring.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jaime.prototype.dao.DataSourceObject;
import com.jaime.prototype.dao.UserDao;
import com.jaime.prototype.dao.impl.DataSourceObjectImpl;
import com.jaime.prototype.dao.impl.UserDaoImpl;

//import com.jaime.prototype.dao.DataSourceObject;

@Configuration
@EnableWebMvc   
@ComponentScan(basePackages="com.jaime.prototype")
public class AppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        
        return viewResolver;
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    
    @Bean
    public DataSourceObject dataSourceObject()   {
        
        DataSourceObject dataSourceObject = new DataSourceObjectImpl();
        
        DataSource dataSource = null;
        try {
            JndiTemplate jndi = new JndiTemplate();
            dataSource = (DataSource) jndi.lookup("java:comp/env/jdbc/myoracle");
        } catch (NamingException e) {
          
            e.printStackTrace();
        }
        dataSourceObject.setDataSource(dataSource);
        
        return dataSourceObject;
    }
    
    @Bean
    public UserDao userDao(){
        
        UserDao userDao = new UserDaoImpl();
        
        return userDao;
    }
}
