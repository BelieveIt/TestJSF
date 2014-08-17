package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DaoUtil {
public static DriverManagerDataSource getDataSource() {
	InputStream inputStream = DaoUtil.class.getResourceAsStream("/jdbcOfMysql.properties");
	Properties properties = new Properties();
	try {
		properties.load(inputStream);
	} catch (IOException e) {
		e.printStackTrace();
	}
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setDriverClassName(properties.getProperty("driverClassName"));
	dataSource.setUrl(properties.getProperty("url"));
	dataSource.setUsername(properties.getProperty("username"));
	dataSource.setPassword(properties.getProperty("password"));
	return dataSource;
}
}
