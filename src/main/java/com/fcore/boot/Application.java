package com.fcore.boot;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.RestController;

import com.fcore.boot.entity.TestPOJO;
import com.fcore.boot.service.TestServices;

@SpringBootApplication
@RestController
@MapperScan("com.fcore.boot.mapper")  
public class Application {
	
	protected static Logger logger=LoggerFactory.getLogger(Application.class);  
	
	@Autowired
	private TestServices testServices;
	  
    @Bean  
    @ConfigurationProperties(prefix="spring.datasource")  
    public DataSource dataSource() {  
        return new org.apache.tomcat.jdbc.pool.DataSource();  
    }  
  
    @Bean  
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {  
  
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();  
        sqlSessionFactoryBean.setDataSource(dataSource());  
  
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();  
  
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/com/fcore/boot/mapper/*.xml"));  
  
        return sqlSessionFactoryBean.getObject();  
    }  
  
    @Bean  
    public PlatformTransactionManager transactionManager() {  
        return new DataSourceTransactionManager(dataSource());  
    }  
    
    @PostConstruct
    public  void init() {
    	//========初始化开始============
    	/*TestPOJO pojo = new TestPOJO();
		pojo.setAge(100);
		pojo.setName("zzzz");
		testServices.save(pojo);*/
    }
    
	public static void main(String[] args) {
		//启动程序
		SpringApplication.run(Application.class, args);
	}
}
