package th.co.pchome.store_j.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "primaryEntityManagerFactory", 
  transactionManagerRef="primaryTransactionManager",
  basePackages = {"th.co.pchome.store_j.repository"}
)
public class OracleConfig {
	
  @Value("${oracle.jndi-name}")
  private String primaryJndi;

  @Bean(name="oracleDataSource")
  @Primary
  public DataSource primaryDatasource() {
	  String active = System.getProperty("spring.profiles.active");
	  if("localhost".equals(active)) {
		  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  	  dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	 	  dataSource.setUrl("jdbc:oracle:thin:@//192.168.21.103:1521/orapdb");
		  dataSource.setUsername("thaiuser");
		  dataSource.setPassword("thuser");
		  return dataSource;
	  }
	  else {
	  
		  JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		  DataSource dataSource = dsLookup.getDataSource(primaryJndi);
		  return dataSource;  
	  }
  }
 
  
  @Primary
  @Bean(name = "primaryEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory( EntityManagerFactoryBuilder builder) {
	  	DataSource dataSource = primaryDatasource();
  	
	  	JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	  	LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
	  	entityManager.setPackagesToScan(new String[]{"th.co.pchome.store_j.entity"});
	  	entityManager.setDataSource(dataSource);
	  	entityManager.setJpaVendorAdapter(vendorAdapter);
	  	entityManager.setPersistenceUnitName("oracle");
	  	HashMap<String, Object> properties = new HashMap<String, Object>();
		  properties.put("hibernate.dialect", "th.co.pchome.store_j.dialect.MyOracleDialect");
		  properties.put("hibernate.naming_strategy", "org.hibernate.cfg.EJB3NamingStrategy");
		  entityManager.setJpaPropertyMap(properties);
	  	return entityManager;
  }
  
  @Primary
  @Bean(name = "primaryTransactionManager")
  public PlatformTransactionManager primaryTransactionManager(EntityManagerFactoryBuilder builder) {
      return new JpaTransactionManager(primaryEntityManagerFactory(builder).getObject());
  }
}
