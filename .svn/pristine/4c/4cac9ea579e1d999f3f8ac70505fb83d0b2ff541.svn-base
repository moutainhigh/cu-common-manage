package com.aotain.common.policyapi;


import com.aotain.common.policyapi.mapper.HouseIpMapper;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.PostConstruct;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/11/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-base-policyapi.xml"})
public class BaseTest {

    private ApplicationContext applicationContext;

    @PostConstruct
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring-base-policyapi.xml");
    }

    @Test
    @Rollback(false)
    public void test(){
        applicationContext.getApplicationName();
        HouseIpMapper houseIpMapper = applicationContext.getBean("houseIpMapper", HouseIpMapper.class);
        System.out.println("=========ok"+houseIpMapper);
    }

    @Test
    public void testMybatis(){
        applicationContext.getApplicationName();
        BasicDataSource basicDataSource = applicationContext.getBean("dataSource", BasicDataSource.class);
//        RedisTemplate redisTemplate = applicationContext.getBean("redisTemplate", RedisTemplate.class);
        SqlSessionFactory sqlSessionFactory = applicationContext.getBean("sqlSessionFactory",SqlSessionFactory.class);
        DataSourceTransactionManager dataSourceTransactionManager = applicationContext.getBean("transactionManager",DataSourceTransactionManager.class);
        System.out.println("dataSourceTransactionManager="+dataSourceTransactionManager);
        System.out.println(basicDataSource + "==========");
        System.out.println(sqlSessionFactory+"========");
        System.out.println("=====ok");
    }
}
