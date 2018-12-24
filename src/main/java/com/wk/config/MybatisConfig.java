package com.wk.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@AutoConfigureAfter({DruidDataSourceConfig.class})
//扫描dao层，basePackages 为dao层所在路径，支持通配符*，多个以,分隔
@MapperScan(basePackages = "com.wk.dao")
@EnableTransactionManagement

public class MybatisConfig implements TransactionManagementConfigurer {


         @Autowired
        //配置文件
        private Environment env;
        @Autowired
        //默认为配置文件中的数据
                DataSource dataSource;

        //根据数据源创建sqlSessionFactory
        @Bean
        public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
            System.out.print("mybatis--Sql 工厂创建");

            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            //指定数据源
            factoryBean.setDataSource(dataSource);
            //指定封装类所在包
            factoryBean.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
            //指定mapper.xml文件所在
            Resource[] resource = new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations"));
            factoryBean.setMapperLocations(resource);

            //添加分页插件
            PageHelper pageHelper = new PageHelper();
            Properties properties = new Properties();
            properties.setProperty("reasonable", "true");
            properties.setProperty("supportMethodsArguments", "true");
            properties.setProperty("returnPageInfo", "check");
            properties.setProperty("params", "count=countSql");
            pageHelper.setProperties(properties);
            factoryBean.setPlugins(new Interceptor[]{pageHelper});
            return factoryBean;
        }

        @Bean
        public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
            System.out.print("mybatis--Sql 模板创建");

            return new SqlSessionTemplate(sqlSessionFactory);
        }

        @Bean
        @Override
        public PlatformTransactionManager annotationDrivenTransactionManager() {
            System.out.print("mybatis--Sql 事物");

            return new DataSourceTransactionManager(dataSource);
        }


/*
@Bean
   public PageHelper page(){

       //分页插件
       System.out.println("开始配置数据分页插件");
       PageHelper pageHelper = new PageHelper();
       Properties properties = new Properties();
       properties.setProperty("offsetAsPageNum","true");
       properties.setProperty("rowBoundsWithCount","true");
       properties.setProperty("reasonable","true");
       properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
       pageHelper.setProperties(properties);
       return pageHelper;
   }*/
    }

