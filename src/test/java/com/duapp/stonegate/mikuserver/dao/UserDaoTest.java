package com.duapp.stonegate.mikuserver.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by chao.zhu
 * 14-4-23
 * 上午12:11
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:/spring/spring-dao.xml")
public class UserDaoTest {
    Logger logger= LoggerFactory.getLogger(getClass());
    @Resource
    UserDao userDao;
    @Test
    public void testSaveUserIfNotExists() throws Exception {

    }

    @Test
    public void testGetUserByUserName() throws Exception {
        logger.debug("user=:{}",userDao.getUserByUserName("123"));
    }

    @Test
    public void testSetSinaToken() throws Exception {

    }
}
