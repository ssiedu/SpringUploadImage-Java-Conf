package com.ssi;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.ssi")
public class DemoAppConfig {

	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multiResolver=new CommonsMultipartResolver();
		multiResolver.setMaxUploadSize(500000);
		return multiResolver;
	}
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setSuffix(".jsp");
		viewResolver.setPrefix("/WEB-INF/views/");
		return viewResolver;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan("com.ssi");
		Properties properties=new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.show_sql","true");
		sessionFactory.setHibernateProperties(properties);
		return sessionFactory;
	}
	
	@Bean
	public  ComboPooledDataSource myDataSource() {
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		try {
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/springdata");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		}catch(Exception e) {}
		return dataSource;
	}
	
}
