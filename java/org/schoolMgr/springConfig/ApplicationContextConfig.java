/**
 * 
 */
package org.schoolMgr.springConfig;

/**
 * @author narajesh
 *
 */
import java.util.Properties;

import javax.sql.DataSource;
 
import org.hibernate.SessionFactory;
import org.schoolMgr.dao.FeesDao;
import org.schoolMgr.dao.StudentDao;
import org.schoolMgr.dao.UserDao;
import org.schoolMgr.dao.impl.FeesDaoImpl;
import org.schoolMgr.dao.impl.StudentDaoImpl;
import org.schoolMgr.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;




 
@Configuration
@EnableScheduling
@EnableAsync
@ComponentScan("org.schoolMgr.*")
@EnableTransactionManagement
// Load to Environment.
@PropertySource("classpath:ds-hibernate-cfg.properties")
public class ApplicationContextConfig {
 
	  private int maxUploadSizeInMb = 5 * 1024 * 1024;
	  
    // The Environment class serves as the property holder
    // and stores all the properties loaded by the @PropertySource
    @Autowired
    private Environment env;
    
  //  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
   
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
        // Load property in message/validator.properties
        rb.setBasenames(new String[] { "messages/validator" });
        return rb;
    }
 
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
     
    // Config for Upload.
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver cmr = new CommonsMultipartResolver();
         
        // Set Max Size...
        // commonsMultipartResolver.setMaxUploadSize(...);
        cmr.setMaxUploadSize(maxUploadSizeInMb * 2);
        cmr.setMaxUploadSizePerFile(maxUploadSizeInMb); //bytes
        return cmr;
    }
 
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
        // See: ds-hibernate-cfg.properties
        dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
        dataSource.setUrl(env.getProperty("ds.url"));
        dataSource.setUsername(env.getProperty("ds.username"));
        dataSource.setPassword(env.getProperty("ds.password"));
         
        System.out.println("## getDataSource: " + dataSource);
         
        return dataSource;
    }
    
   
 
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
        Properties properties = new Properties();
 
        // See: ds-hibernate-cfg.properties
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("current_session_context_class", env.getProperty("current_session_context_class"));
         
 
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
         
        // Package contain entity classes
        factoryBean.setPackagesToScan(new String[] { "org.schoolMgr.entity" });
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(properties);
        factoryBean.afterPropertiesSet();
        //
        SessionFactory sf = factoryBean.getObject();
        System.out.println("## getSessionFactory: " + sf);
        return sf;
    }
 
    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
 
        return transactionManager;
    }
 
    @Bean(name = "UserDao")
    public UserDao getUserDAO() {
        return new UserDaoImpl();
    }
    
    @Bean(name = "FeesDao")
    public FeesDao getFeesDao() {
        return new FeesDaoImpl();
    }
 
    @Bean(name = "StudentDao")
    public StudentDao getStudentDao() {
        return new StudentDaoImpl();
    }
   
}
