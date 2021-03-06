package elen7045.group5.project.aps.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "elen7045.group5.project.aps.jpa.service", "elen7045.group5.project.aps", "elen7045.group5.project.notify.service" })
@EnableTransactionManagement
@ImportResource("classpath:applicationContext.xml")
@PropertySource("classpath:application.properties")
public class ApplicationContext
{

	private static final String	PROPERTY_NAME_DATABASE_DRIVER					= "db.driver";
	private static final String	PROPERTY_NAME_DATABASE_PASSWORD					= "db.password";
	private static final String	PROPERTY_NAME_DATABASE_URL						= "db.url";
	private static final String	PROPERTY_NAME_DATABASE_USERNAME					= "db.username";

	private static final String	PROPERTY_NAME_HIBERNATE_DIALECT					= "hibernate.dialect";
	private static final String	PROPERTY_NAME_HIBERNATE_FORMAT_SQL				= "hibernate.format_sql";
	private static final String	PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO			= "hibernate.hbm2ddl.auto";
	private static final String	PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY			= "hibernate.ejb.naming_strategy";
	private static final String	PROPERTY_NAME_HIBERNATE_SHOW_SQL				= "hibernate.show_sql";
	private static final String	PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN	= "entitymanager.packages.to.scan";

	@Resource
	private Environment			environment;

	@Bean
	public DataSource dataSource()
	{
		BasicDataSource dataSource = new org.apache.commons.dbcp.BasicDataSource();

		dataSource.setDriverClassName(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

		return dataSource;
	}

	@Bean
	public JpaTransactionManager transactionManager() throws ClassNotFoundException
	{
		JpaTransactionManager transactionManager = new JpaTransactionManager();

		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());

		return transactionManager;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
			throws ClassNotFoundException
	{
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan(environment
				.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);

		Properties jpaProterties = new Properties();
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_DIALECT,
				environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL,
				environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO,
				environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY,
				environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL,
				environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));

		entityManagerFactoryBean.setJpaProperties(jpaProterties);

		return entityManagerFactoryBean;
	}
	
	@Bean
	public LoggingAspect loggingAspect() throws ClassNotFoundException {
		LoggingAspect loggingAspect = new LoggingAspect();
		return loggingAspect;
	}


}
