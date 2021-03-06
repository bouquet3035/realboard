package com.realboard.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.realboard.convenience")
public class DatabaseConfig {

		private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

		
		@Autowired
		ApplicationContext applicationContext;

		@Bean
		public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
			SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
			sessionFactory.setDataSource(dataSource);
			Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mappers/**/*.xml");
			sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
			sessionFactory.setMapperLocations(res);

			logger.error("sessionFactory.getObject()=" + sessionFactory);
			logger.error("sessionFactory.getObject()=" + sessionFactory.getObject());
			return sessionFactory.getObject();
		}

	
}
