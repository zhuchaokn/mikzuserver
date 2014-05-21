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
 * 下午11:02
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:/spring/spring-dao.xml")
public class InstructionDaoTest {
    private Logger logger= LoggerFactory.getLogger(getClass());
    @Resource
    InstructionDao instructionDao;
    @Test
    public void testGetCommand() throws Exception {
        logger.debug("ins=:{}",instructionDao.getCommand("问"));
    }

    @Test
    public void testGetInstructionByKey() throws Exception {
        logger.debug("ins=:{}",instructionDao.getInstructionByKey("问"));
    }

    @Test
    public void testGetInstructionByCommandNum() throws Exception {
    }
}
